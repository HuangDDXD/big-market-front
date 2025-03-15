package com.dd.domain.strategy.repository;

import com.dd.domain.strategy.model.StrategyAwardEntity;
import com.dd.domain.strategy.model.StrategyEntity;
import com.dd.domain.strategy.model.StrategyRuleEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Jojo3
 * @description 策略仓储
 * @date 2025/3/12 20:10
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> shuffleStrategyAwardSearchRateTable);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    StrategyEntity queryStrategyEntityList(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleWeight);
}
