package com.hbq.cms.service;

import com.hbq.cms.model.Drug;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 药品
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
public interface IDrugService extends IService<Drug> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

