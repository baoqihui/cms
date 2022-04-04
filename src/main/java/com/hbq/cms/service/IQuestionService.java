package com.hbq.cms.service;

import com.hbq.cms.model.Question;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 问题
 *
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
public interface IQuestionService extends IService<Question> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}

