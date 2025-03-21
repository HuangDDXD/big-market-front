package com.dd.domain.strategy.service.rule.tree.impl;

import com.dd.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.dd.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.dd.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Jojo3
 * @description 次数锁节点
 * @date 2025/3/21 16:46
 */
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckTypeVO(RuleLogicCheckTypeVO.ALLOW)
                .build();
    }
}
