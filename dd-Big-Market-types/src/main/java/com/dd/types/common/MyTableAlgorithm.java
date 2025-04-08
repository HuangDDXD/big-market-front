package com.dd.types.common;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * @author Jojo3
 * @description 自定义分表算法
 * @date 2025/4/8 16:37
 */
public class MyTableAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties props;

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        int tableSize = collection.size();
        // 真实表的前缀
        String tablePrefix = preciseShardingValue.getDataNodeInfo().getPrefix();
        // 分片健的值
        long orderId = preciseShardingValue.getValue().hashCode() / 2;
        // 对分片健取模后确定位置
        long mod = orderId % tableSize;
        return tablePrefix +"00"+ mod;
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        return collection;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public Properties getProps() {
        return props;
    }

    @Override
    public void init(Properties properties) {
        props = properties;
    }
}
