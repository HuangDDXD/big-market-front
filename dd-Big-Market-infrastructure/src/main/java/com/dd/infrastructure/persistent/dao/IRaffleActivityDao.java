package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jojo3
 * @description 抽奖活动表Dao
 * @date 2025/4/8 18:04
 */
@Mapper
public interface IRaffleActivityDao {

    RaffleActivity queryRaffleActivityByActivityId(Long activityId);
}
