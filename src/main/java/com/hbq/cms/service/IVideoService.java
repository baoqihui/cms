package com.hbq.cms.service;

import com.hbq.cms.model.Video;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 视频
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
public interface IVideoService extends IService<Video> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

