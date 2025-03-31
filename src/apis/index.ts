// 请求地址
import {strategy} from "sharp";

const apiHostUrl = process.env.API_HOST_URL ? process.env.API_HOST_URL : "http://localhost:8091";

/**
 * 装配抽奖
 * @param strategyId 策略ID
 */
export const strategyArmory = (strategyId?: number) => {
    return fetch(`${apiHostUrl}/api/v1/raffle/strategy_armory?strategyId=${strategyId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
}

/**
 * 查询抽奖奖品列表
 * @param strategyId 策略ID
 */
export const queryRaffleAwardList = (strategyId: number | undefined) => {
    try {
        return fetch(`${apiHostUrl}/api/v1/raffle/query_raffle_award_list`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                strategyId: strategyId
            })
        });
    } catch (error) {
        return fetch("{\n" +
            "    \"code\": \"0001\",\n" +
            "    \"info\": \"调用失败\",\n" +
            "    \"data\": [\n" +
            "}");
    }
}

export const randomRaffle = (strategyId: number) => {
    try {
        return fetch(`${apiHostUrl}/api/v1/raffle/random_raffle`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                strategyId: strategyId
            })
        })
    } catch (error) {
        return fetch("{\n" +
            "    \"code\": \"0001\",\n" +
            "    \"info\": \"调用失败\",\n" +
            "    \"data\": [\n" +
            "}");
    }
}