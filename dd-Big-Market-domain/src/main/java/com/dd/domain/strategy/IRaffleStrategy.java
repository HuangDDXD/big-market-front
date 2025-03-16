package com.dd.domain.strategy;

import com.dd.domain.strategy.model.entity.RaffleAwardEntity;
import com.dd.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @author Jojo3
 * @description 抽奖策略接口
 * @date 2025/3/15 20:39
 */
public interface IRaffleStrategy {

    /**
     * 执行抽奖：用抽奖因子入参，执行抽奖计算返回奖品信息
     *
     * @param raffleFactorEntity 抽奖因子实体对象，根据入参信息计算抽奖结果
     * @return  抽奖的奖品
     */
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
