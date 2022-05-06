package com.hbq.cms.service;

import com.hbq.cms.model.UserTrains;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 用户培训
 *
 * @author hbq
 * @date 2022-05-06 11:49:32
 */
public interface IUserTrainsService extends IService<UserTrains> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

