package com.dd.domain.strategy.service.rule.tree.factory.engine;

import com.dd.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author Jojo3
 * @description 规则树组合接口
 * @date 2025/3/21 17:11
 */
public interface IDecisionTreeEngine {

    DefaultTreeFactory.StrategyAwardData process(String userId, Long StrategyId, Integer awardId);
}
