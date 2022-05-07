package com.hbq.cms.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.mapper.TrainsMapper;
import com.hbq.cms.model.Trains;
import com.hbq.cms.service.ITrainsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 培训安排
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Slf4j
@Service
@AllArgsConstructor
public class TrainsServiceImpl extends ServiceImpl<TrainsMapper, Trains> implements ITrainsService {
    private TrainsMapper trainsMapper;
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public Page<Map> findList(Map<String, Object> params){
        Integer pageNum = MapUtil.getInt(params, "pageNum");
        Integer pageSize = MapUtil.getInt(params, "pageSize");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = -1;
        }
        Page<Map> pages = new Page<>(pageNum, pageSize);
        return trainsMapper.findList(pages, params);
    }
}
