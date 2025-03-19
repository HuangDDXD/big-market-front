package com.dd.domain.strategy.service.rule.chain.factory;

import com.dd.domain.strategy.model.entity.StrategyEntity;
import com.dd.domain.strategy.repository.IStrategyRepository;
import com.dd.domain.strategy.service.rule.chain.ILogicChain;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jojo3
 * @description 工厂
 * @date 2025/3/18 19:37
 */
@Service
public class DefaultChainFactory {

    private final Map<String, ILogicChain> logicChainGroup;

    protected IStrategyRepository repository;

    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup, IStrategyRepository repository) {
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }

    public ILogicChain openLogicChain(Long strategyId) {
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);
        String[] ruleModels = strategy.ruleModels();

        // 如果未配置策略规则，则指装填一个默认责任链
        if (ruleModels == null || ruleModels.length == 0) {
            return logicChainGroup.get("default");
        }

        // 按照配置顺序装填用户配置的责任链：
        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        for (int i = 1; i < ruleModels.length; i ++) {
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current = current.appendNext(nextChain);
        }

        // 责任链的最后装填默认责任链
        current.appendNext(logicChainGroup.get("default"));

        return logicChain;
    }
}
