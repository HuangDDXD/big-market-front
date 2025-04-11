package com.dd.domain.activity.repository;

import com.dd.domain.activity.model.entity.ActivityCountEntity;
import com.dd.domain.activity.model.entity.ActivityEntity;
import com.dd.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author Jojo3
 * @description 活动仓储接口
 * @date 2025/4/11 14:25
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActvityCountId(Long activityCountId);
}
