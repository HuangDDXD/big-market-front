package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jojo3
 * @description 规则树表DAO
 * @date 2025/3/22 15:38
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);
}
