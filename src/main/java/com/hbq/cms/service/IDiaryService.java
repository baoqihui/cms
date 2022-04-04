package com.hbq.cms.service;

import com.hbq.cms.model.Diary;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 日记
 *
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
public interface IDiaryService extends IService<Diary> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);
}
