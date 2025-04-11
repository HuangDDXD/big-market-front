package com.dd.infrastructure.persistent.dao;


import com.dd.infrastructure.persistent.po.RaffleActivityOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jojo3
 * @description 抽奖活动单Dao
 * @create 2024-03-09 10:08
 */
@Mapper
public interface IRaffleActivityOrderDao {

    void insert(RaffleActivityOrder raffleActivityOrder);

    List<RaffleActivityOrder> queryRaffleActivityOrderByUserId(String userId);

}
