package com.hbq.cms.service;

import com.hbq.cms.model.Clock;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 打卡
 *
 * @author hbq
 * @date 2022-05-01 09:28:40
 */
public interface IClockService extends IService<Clock> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

