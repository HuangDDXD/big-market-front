package com.dd.domain.strategy.service.rule.chain;

/**
 * @author Jojo3
 * @description 责任链装配
 * @date 2025/3/18 18:57
 */
public interface ILogicChainArmory {

    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);
}
