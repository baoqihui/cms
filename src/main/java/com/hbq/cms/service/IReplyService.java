package com.hbq.cms.service;

import com.hbq.cms.model.Reply;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 回复
 *
 * @author hbq
 * @date 2022-04-04 14:39:49
 */
public interface IReplyService extends IService<Reply> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

