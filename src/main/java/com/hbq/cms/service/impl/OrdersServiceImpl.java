package com.hbq.cms.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.mapper.OrdersMapper;
import com.hbq.cms.model.Orders;
import com.hbq.cms.service.IOrdersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 就诊单
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    private OrdersMapper ordersMapper;
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
        return ordersMapper.findList(pages, params);
    }

    @Override
    public Result delete(Long id) {
        Orders orders = getById(id);
        if (ObjectUtil.isNull(orders)) {
            return Result.failed("就诊单不存在");
        }
        if (ObjectUtil.equal(orders.getStatus(), 2)) {
            return Result.failed("就诊单已经完成，不能删除");
        }
        boolean b = removeById(id);
        if (b) {
            return Result.succeed("删除成功");
        }else {
            return Result.failed("删除失败");
        }
    }
}
