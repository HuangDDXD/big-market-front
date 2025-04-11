package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jojo3
 * @description 商品sku dao
 * @date 2025/4/10 23:36
 */
@Mapper
public interface IRaffleActivitySkuDao {

    RaffleActivitySku queryActivitySku(Long sku);
}
