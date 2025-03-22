package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jojo3
 * @description 规则树节点连线表DAO
 * @date 2025/3/22 15:39
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);
}
