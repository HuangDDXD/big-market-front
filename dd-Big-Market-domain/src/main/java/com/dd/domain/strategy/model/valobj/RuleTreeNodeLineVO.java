package com.dd.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jojo3
 * @description 规则树节点指向线对象。用于衔接 from->to 节点链路关系
 * @date 2025/3/20 16:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleTreeNodeLineVO {

    /** 规则树ID */
    private Integer treeId;
    /** 规则Key节点 From */
    private String ruleNodeFrom;
    /** 规则Key节点 To */
    private String ruleNodeTo;
    /** 限定类型 */
    private RuleLimitTypeVO ruleLimitType;
    /** 限定值 */
    private RuleLogicCheckTypeVO ruleLimitValue;
}
