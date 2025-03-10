package com.dd.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jojo3
 * @date 2025/3/9 20:33
 * @description
 */
@Data
public class Strategy {
    /**自增ID*/
    private Long id;
    /**抽奖策略ID*/
    private Long strategyId;
    /**抽奖策略描述*/
    private String strategyDesc;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
}
