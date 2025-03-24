package com.dd.domain.strategy.service.armory;

/**
 * @author Jojo3
 * @description 策略抽奖调度
 * @date 2025/3/13 20:34
 */
public interface IStrategyDispatch {

    /**
     *  获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @return 扣减结果
     */
    Boolean subtractionAwardStock(Long strategyId, Integer awardId);
}
