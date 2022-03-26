package com.hbq.cms.service;

import com.hbq.cms.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 用户表
 *
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
public interface IUserService extends IService<User> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

