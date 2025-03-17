package com.dd.domain.strategy.model.entity;

import com.dd.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * @author Jojo3
 * @description 规则动作实体
 * @date 2025/3/16 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleActionEntity<T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    private T data;

    public static class RaffleEntity {

    }

    //抽奖之前
    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RaffleBeforeEntity extends RaffleEntity {

        /**
         *  策略ID
         */
        private Long strategyId;

        /**
         *  权重Key：用于抽奖时可以选择权重抽奖
         */
        private String ruleWeightValueKey;

        /**
         *  奖品ID
         */
        private Integer awardId;
    }

    // 抽奖之中
    static public class RaffleCenterEntity extends RaffleEntity {
    }

    // 抽奖之后
    static public class RaffleAfterEntity extends RaffleEntity {

    }

}
