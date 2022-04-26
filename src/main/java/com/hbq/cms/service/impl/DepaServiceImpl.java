package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.DepaMapper;
import com.hbq.cms.service.IDepaService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Depa;

/**
 * 部门
 *
 * @author hbq
 * @date 2022-04-26 18:21:27
 */
@Slf4j
@Service
@AllArgsConstructor
public class DepaServiceImpl extends ServiceImpl<DepaMapper, Depa> implements IDepaService {
    private DepaMapper depaMapper;
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
        return depaMapper.findList(pages, params);
    }
}
