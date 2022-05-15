package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.MedicalsMapper;
import com.hbq.cms.service.IMedicalsService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Medicals;

/**
 * 医疗内容
 *
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
@Slf4j
@Service
@AllArgsConstructor
public class MedicalsServiceImpl extends ServiceImpl<MedicalsMapper, Medicals> implements IMedicalsService {
    private MedicalsMapper medicalsMapper;
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
        return medicalsMapper.findList(pages, params);
    }
}