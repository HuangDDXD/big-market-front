package com.dd.domain.strategy.service.rule.tree;

import com.dd.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author Jojo3
 * @description 规则树接口
 * @date 2025/3/21 16:44
 */
public interface ILogicTreeNode {

    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue);
}
