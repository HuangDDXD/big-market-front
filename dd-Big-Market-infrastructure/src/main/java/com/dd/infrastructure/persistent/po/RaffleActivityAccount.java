package com.dd.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Jojo3
 * @description 抽奖活动次数配置表 持久化对象
 * @date 2025/4/7 17:55
 */
@Data
public class RaffleActivityAccount {

    /** 自增ID */
    private Long id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 总次数 */
    private Integer totalCount;
    /** 总次数 */
    private Integer totalCountSurplus;
    /** 日次数 */
    private Integer dayCount;
    /** 剩余 */
    private Integer dayCountSurplus;
    /** 月次数 */
    private Integer monthCount;
    /** 剩余 */
    private Integer monthCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
