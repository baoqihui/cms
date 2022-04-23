package com.hbq.cms.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.mapper.DrugMapper;
import com.hbq.cms.model.Drug;
import com.hbq.cms.service.IDrugService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 药品
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Slf4j
@Service
@AllArgsConstructor
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements IDrugService {
    private DrugMapper drugMapper;
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
        return drugMapper.findList(pages, params);
    }
}
