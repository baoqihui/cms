package com.hbq.cms.service;

import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Orders;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 就诊单
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
public interface IOrdersService extends IService<Orders> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);

    Result delete(Long id);
}

