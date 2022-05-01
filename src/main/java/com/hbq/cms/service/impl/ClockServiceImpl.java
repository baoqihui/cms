package com.hbq.cms.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.mapper.ClockMapper;
import com.hbq.cms.model.Clock;
import com.hbq.cms.service.IClockService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 打卡
 *
 * @author hbq
 * @date 2022-05-01 09:28:40
 */
@Slf4j
@Service
@AllArgsConstructor
public class ClockServiceImpl extends ServiceImpl<ClockMapper, Clock> implements IClockService {
    private ClockMapper clockMapper;
    /**
     * 列表
     * @param params
     * @return
     */
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
        return clockMapper.findList(pages, params);
    }
}
