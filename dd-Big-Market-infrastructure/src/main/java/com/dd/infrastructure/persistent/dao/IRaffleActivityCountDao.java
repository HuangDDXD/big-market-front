package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jojo3
 * @description 抽奖活动次数配置表   Dao
 * @create 2024-03-09 10:07
 */
@Mapper
public interface IRaffleActivityCountDao {

    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);
}
