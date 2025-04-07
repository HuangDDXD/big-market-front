package com.dd.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Jojo3
 * @description 抽奖活动账户流水表 持久化对象
 * @date 2025/4/7 18:20
 */
@Data
public class RaffleActivityAccountFlow {

    /** 自增ID */
    private Long id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 总次数 */
    private Integer totalCount;
    /** 日次数 */
    private Integer dayCount;
    /** 月次数 */
    private Integer monthCount;
    /** 流水ID */
    private String flowId;
    /** 流水渠道 */
    private String flowChannel;
    /** 业务ID */
    private String bizId;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
