package com.dd.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jojo3
 * @description 抽奖策略 持久化对象
 * @date 2025/3/9 20:33
 */
@Data
public class Strategy {
    /**自增ID*/
    private Long id;
    /**抽奖策略ID*/
    private Long strategyId;
    /**抽奖策略描述*/
    private String strategyDesc;
    /** 抽奖规则模型 rule_weight,rule_blacklist */
    private String ruleModels;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
}
