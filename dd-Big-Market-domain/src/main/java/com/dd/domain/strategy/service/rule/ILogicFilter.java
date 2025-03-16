package com.dd.domain.strategy.service.rule;

import com.dd.domain.strategy.model.entity.RuleActionEntity;
import com.dd.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @author Jojo3
 * @description 抽奖规则过滤接口
 * @date 2025/3/16 16:13
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
