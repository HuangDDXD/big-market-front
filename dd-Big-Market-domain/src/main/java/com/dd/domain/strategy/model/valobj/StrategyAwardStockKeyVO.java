package com.dd.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jojo3
 * @description 策略奖品库存Key标识值对象
 * @date 2025/3/24 20:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyAwardStockKeyVO {

    // 策略ID
    private Long strategyId;
    // 奖品ID
    private Integer awardId;
}
