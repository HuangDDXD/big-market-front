package com.dd.domain.strategy.service.rule.tree.impl;

import com.dd.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.dd.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import com.dd.domain.strategy.repository.IStrategyRepository;
import com.dd.domain.strategy.service.armory.IStrategyDispatch;
import com.dd.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.dd.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Jojo3
 * @description 库存扣减节点
 * @date 2025/3/21 16:48
 */
@Slf4j
@Component("rule_stock")
public class RuleStockLogicTreeNode implements ILogicTreeNode {

    @Resource
    private IStrategyDispatch strategyDispatch;
    @Resource
    private IStrategyRepository repository;

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue) {
        log.info("规则过滤-库存扣减 userId:{} strategyId:{} awardId:{}", userId, strategyId, awardId);

        // 扣减库存
        Boolean status = strategyDispatch.subtractionAwardStock(strategyId, awardId);
        // ture:库存扣减成功，TAKE_OVER 规则节点接管，返回奖品ID，奖品规则配置
        if (status) {
            log.info("规则过滤-库存扣减-成功 userId:{} strategyId:{} awardId:{}", userId, strategyId, awardId);

            // 写入延迟队列，延迟削废更新数据库记录【在trigger的job；UpdateAwardStockJob 下消费队列，更新数据库记录】
            repository.awardStockConsumeSendQueue(StrategyAwardStockKeyVO.builder()
                    .strategyId(strategyId)
                    .awardId(awardId)
                    .build());

            return DefaultTreeFactory.TreeActionEntity.builder()
                    .ruleLogicCheckTypeVO(RuleLogicCheckTypeVO.TAKE_OVER)
                    .strategyAwardData(DefaultTreeFactory.StrategyAwardVO.builder()
                            .awardId(awardId)
                            .awardRuleValue(ruleValue)
                            .build()
                    )
                    .build();
        }
        // 如果库存不足，则直接返回放行
        log.warn("规则过滤-库存扣减-告警，库存不足。userId:{} strategyId:{} awardId:{}", userId, strategyId, awardId);
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckTypeVO(RuleLogicCheckTypeVO.ALLOW)
                .build();
    }
}
