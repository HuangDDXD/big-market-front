package com.dd.domain.strategy.model;

import com.dd.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author Jojo3
 * @description 策略实体
 * @date 2025/3/14 20:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StrategyEntity {

    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 抽奖规则模型 rule_weight,rule_blacklist */
    private String ruleModels;

    public String[] ruleModels() {
        if (StringUtils.isBlank(ruleModels)) {
            return null;
        }
        return ruleModels.split(Constants.SPLIT);
    }

    public String getRuleWeight() {
        String[] ruleModels = this.ruleModels();
        return Arrays.stream(ruleModels)
                .filter("rule_weight"::equals)
                .findFirst()
                .orElse(null);
    }
}
