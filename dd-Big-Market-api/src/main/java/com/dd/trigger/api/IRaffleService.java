package com.dd.trigger.api;

import com.dd.trigger.api.dto.RaffleAwardListRequestDTO;
import com.dd.trigger.api.dto.RaffleAwardListResponseDTO;
import com.dd.trigger.api.dto.RaffleRequestDTO;
import com.dd.trigger.api.dto.RaffleResponseDTO;
import com.dd.types.model.Response;

import java.util.List;

/**
 * @author Jojo3
 * @description 抽奖服务接口
 * @date 2025/3/29 15:44
 */
public interface IRaffleService {

    /**
     * 策略装配接口
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);

    /**
     * 查询抽奖奖品列表配置
     *
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    /**
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleResponseDTO> randomRaffle(RaffleRequestDTO requestDTO);
}
