package com.dd.domain.activity.service;

import com.dd.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @author Jojo3
 * @description 抽奖活动服务
 * @date 2025/4/11 14:34
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity {

    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }
}
