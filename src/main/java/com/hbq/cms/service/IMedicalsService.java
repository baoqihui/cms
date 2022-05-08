package com.hbq.cms.service;

import com.hbq.cms.model.Medicals;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 医疗内容
 *
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
public interface IMedicalsService extends IService<Medicals> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

