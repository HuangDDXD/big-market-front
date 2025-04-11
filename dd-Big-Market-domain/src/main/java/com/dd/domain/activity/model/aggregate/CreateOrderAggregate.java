package com.dd.domain.activity.model.aggregate;

import com.dd.domain.activity.model.entity.ActivityAccountEntity;
import com.dd.domain.activity.model.entity.ActivityOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jojo3
 * @description 下单聚合对象
 * @date 2025/4/11 14:18
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderAggregate {

    /**
     * 活动账户实体
     */
    private ActivityAccountEntity activityAccountEntity;
    /**
     * 活动订单实体
     */
    private ActivityOrderEntity activityOrderEntity;
}
