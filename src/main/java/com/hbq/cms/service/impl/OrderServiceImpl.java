package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.OrderMapper;
import com.hbq.cms.service.IOrderService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Order;

/**
 * 就诊单
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    private OrderMapper orderMapper;
    /**
     * 列表
     * @param params
     * @return
     */
    public Page<Map> findList(Map<String, Object> params){
        Integer pageNum = MapUtil.getInt(params, "pageNum");
        Integer pageSize = MapUtil.getInt(params, "pageSize");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = -1;
        }
        Page<Map> pages = new Page<>(pageNum, pageSize);
        return orderMapper.findList(pages, params);
    }
}
