package com.hbq.cms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.dto.MediaDto;
import com.hbq.cms.model.Media;

import java.util.Map;

/**
 * 媒体
 *
 * @author hbq
 * @date 2022-03-26 19:40:25
 */
public interface IMediaService extends IService<Media> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);

    Result share(MediaDto mediaDto);
}

