package com.dd.domain.activity.service;

import com.alibaba.fastjson.JSON;
import com.dd.domain.activity.model.entity.*;
import com.dd.domain.activity.repository.IActivityRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jojo3
 * @description 抽奖活动抽象类，定义标准的流程
 * @date 2025/4/11 14:24
 */
@Slf4j
public abstract class AbstractRaffleActivity implements IRaffleOrder{

    protected IActivityRepository activityRepository;

    public AbstractRaffleActivity(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity) {
        // 通过sku查询活动信息
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(activityShopCartEntity.getSku());
        // 查询活动信息
        ActivityEntity activityEntity = activityRepository.queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        // 查询次数信息
        ActivityCountEntity activityCountEntity = activityRepository.queryRaffleActivityCountByActvityCountId(activitySkuEntity.getActivityCountId());

        log.info("查询结果：{} {} {}", JSON.toJSONString(activitySkuEntity), JSON.toJSONString(activityEntity), JSON.toJSONString(activityCountEntity));

        return ActivityOrderEntity.builder().build();
    }
}
