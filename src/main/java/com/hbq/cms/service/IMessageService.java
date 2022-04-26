package com.hbq.cms.service;

import com.hbq.cms.model.Message;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 消息/汇报
 *
 * @author hbq
 * @date 2022-04-26 18:21:26
 */
public interface IMessageService extends IService<Message> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

