package com.dd.domain.strategy.service.rule.tree.factory;

import com.dd.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.dd.domain.strategy.model.valobj.RuleTreeVO;
import com.dd.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.dd.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import com.dd.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jojo3
 * @description 规则树工厂
 * @date 2025/3/21 17:04
 */
@Service
public class DefaultTreeFactory {

    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }

    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }

    /**
     * 决策树动作实体
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckTypeVO;
        private StrategyAwardVO strategyAwardData;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class StrategyAwardVO {
        /** 抽奖奖品ID - 内部流转使用 */
        private Integer awardId;
        /** 抽奖品规则 */
        private String awardRuleValue;
    }
}
