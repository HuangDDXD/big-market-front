package com.dd.trigger.api.dto;

import lombok.Data;

/**
 * @author Jojo3
 * @description 抽奖奖品列表，请求对象
 * @date 2025/3/29 16:19
 */
@Data
public class RaffleAwardListRequestDTO {
    // 抽奖策略ID
    private Long strategyId;
}
