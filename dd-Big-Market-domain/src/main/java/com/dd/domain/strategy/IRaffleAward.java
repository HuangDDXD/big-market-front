package com.dd.domain.strategy;

import com.dd.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @author Jojo3
 * @description 策略奖品接口
 * @date 2025/3/29 16:04
 */
public interface IRaffleAward {

    /**
     * 根据策略ID查询抽奖奖品列表配置
     *
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}
