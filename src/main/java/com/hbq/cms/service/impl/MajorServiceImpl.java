package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.MajorMapper;
import com.hbq.cms.service.IMajorService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Major;

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
