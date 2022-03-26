package com.hbq.cms.service;

import com.hbq.cms.model.Banner;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 轮播图
 *
 * @author hbq
 * @date 2022-03-26 19:53:05
 */
public interface IBannerService extends IService<Banner> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

