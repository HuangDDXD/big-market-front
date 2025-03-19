package com.dd.domain.strategy.service.rule.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jojo3
 * @description 抽奖策略责任链，判断走那种抽奖策略。如；默认抽象、权重抽奖、黑名单抽奖
 * @date 2025/3/18 19:00
 */
@Slf4j
public abstract class AbstractLoginChain implements ILogicChain {

    private ILogicChain next;

    @Override
    public ILogicChain next() {
        return next;
    }

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    protected abstract String ruleModel();
}
