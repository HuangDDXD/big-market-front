package com.dd.domain.strategy;

import com.dd.domain.strategy.IRaffleStrategy;
import com.dd.domain.strategy.model.entity.RaffleAwardEntity;
import com.dd.domain.strategy.model.entity.RaffleFactorEntity;
import com.dd.domain.strategy.model.entity.RuleActionEntity;
import com.dd.domain.strategy.model.entity.StrategyEntity;
import com.dd.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.dd.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import com.dd.domain.strategy.repository.IStrategyRepository;
import com.dd.domain.strategy.service.armory.IStrategyDispatch;
import com.dd.domain.strategy.service.rule.chain.ILogicChain;
import com.dd.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import com.dd.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import com.dd.types.enums.ResponseCode;
import com.dd.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Jojo3
 * @description 抽奖策略抽象类，定义抽奖的标准流程
 * @date 2025/3/16 15:54
 */
@Slf4j
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {

    // 策略仓储服务 -> domain层像一个大厨，仓储层提供米面粮油
    protected IStrategyRepository repository;
    // 策略调度服务 -> 只负责抽奖处理，通过新增接口的方式，隔离职责，不需要使用方关心或者调用抽奖的初始化
    protected IStrategyDispatch strategyDispatch;
    // 抽奖的责任链 -> 从抽奖的规则中，解耦出前置规则为责任链处理
    private final DefaultChainFactory defaultChainFactory;

    public AbstractRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory) {
        this.repository = repository;
        this.strategyDispatch = strategyDispatch;
        this.defaultChainFactory = defaultChainFactory;
    }

    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        // 参数校验
        String userId = raffleFactorEntity.getUserId();
        Long strategyId = raffleFactorEntity.getStrategyId();
        if (strategyId == null || StringUtils.isBlank(userId)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 获取抽奖责任链 - 前置规则的责任链处理
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);

        // 通过责任链获得奖品ID
        Integer awardId = logicChain.logic(userId, strategyId);

        // 查询奖品规则
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModelVO(strategyId, awardId);

        // 抽奖中 = 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleCenterEntity> ruleActionCenterEntity = this.doCheckRaffleCenterLogic(RaffleFactorEntity.builder()
                .strategyId(strategyId)
                .userId(userId)
                .awardId(awardId)
                .build(), strategyAwardRuleModelVO.raffleCenterModelList());

        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionCenterEntity.getCode())) {
            log.info("【临时日志】中奖中规则拦截，通过抽奖后规则 rule_luck_award 走兜底奖励。");
            return RaffleAwardEntity.builder()
                    .awardDesc("中奖中规则拦截，通过抽奖后规则 rule_luck_award 走兜底奖励。")
                    .build();
        }

        return RaffleAwardEntity.builder()
                .awardId(awardId)
                .build();
    }

    protected abstract RuleActionEntity<RuleActionEntity.RaffleCenterEntity> doCheckRaffleCenterLogic(RaffleFactorEntity raffleFactorEntity, String ...logics);
}
