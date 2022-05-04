package com.hbq.cms.service;

import com.hbq.cms.model.Major;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 专业
 *
 * @author hbq
 * @date 2022-05-04 20:15:25
 */
public interface IMajorService extends IService<Major> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

