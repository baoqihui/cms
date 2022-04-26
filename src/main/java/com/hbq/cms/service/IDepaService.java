package com.hbq.cms.service;

import com.hbq.cms.model.Depa;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 部门
 *
 * @author hbq
 * @date 2022-04-26 18:21:27
 */
public interface IDepaService extends IService<Depa> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

