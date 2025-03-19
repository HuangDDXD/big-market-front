package com.dd.domain.strategy.model.valobj;

import com.dd.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import com.dd.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author Jojo3
 * @description 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @date 2025/3/17 18:18
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyAwardRuleModelVO {

    private String ruleModels;

    public String[] raffleCenterModelList() {
        if (StringUtils.isBlank(ruleModels)) {
            return null;
        }
        return Arrays.stream(ruleModels.split(Constants.SPLIT))
                .filter(DefaultLogicFactory.LogicModel::isCenter).toArray(String[]::new);
    }

    public String[] raffleAfterRuleModelList() {
        return Arrays.stream(ruleModels.split(Constants.SPLIT))
                .filter(DefaultLogicFactory.LogicModel::isAfter).toArray(String[]::new);
    }
}
