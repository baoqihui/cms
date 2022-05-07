package com.hbq.cms.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.mapper.MajorMapper;
import com.hbq.cms.model.Major;
import com.hbq.cms.service.IMajorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 专业
 *
 * @author hbq
 * @date 2022-05-04 20:15:25
 */
@Slf4j
@Service
@AllArgsConstructor
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {
    private MajorMapper majorMapper;
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
        return majorMapper.findList(pages, params);
    }
}
