package com.hbq.cms.mapper;

import com.hbq.cms.model.Order;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 就诊单
 * 
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Mapper
public interface OrderMapper extends SuperMapper<Order> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
