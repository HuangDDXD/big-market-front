package com.dd.domain.strategy.repository;

import com.dd.domain.strategy.model.StrategyAwardEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Jojo3
 * @description 策略仓储
 * @date 2025/3/12 20:10
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(Long strategyId, Integer rateRange, Map<Integer, Integer> shuffleStrategyAwardSearchRateTable);

    int getRateRange(Long strategyId);

    Integer getStrategyAwardAssemble(Long strategyId, Integer rateKey);
}
