package com.dd.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Jojo3
 * @description 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @date 2025/3/17 18:18
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyAwardRuleModelVO {

    private String ruleModels;
}
