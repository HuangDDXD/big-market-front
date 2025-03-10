package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jojo3
 * @description 奖品表Dao
 * @date 2025/3/10 16:03
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

}
