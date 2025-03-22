package com.dd.infrastructure.persistent.dao;

import com.dd.infrastructure.persistent.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jojo3
 * @description 规则树节点表DAO
 * @date 2025/3/22 15:38
 */
@Mapper
public interface IRuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);
}
