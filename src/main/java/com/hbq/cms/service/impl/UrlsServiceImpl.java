package com.hbq.cms.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.mapper.UrlsMapper;
import com.hbq.cms.model.Urls;
import com.hbq.cms.service.IUrlsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 友情链接表
 *
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
@Slf4j
@Service
@AllArgsConstructor
public class UrlsServiceImpl extends ServiceImpl<UrlsMapper, Urls> implements IUrlsService {
    private UrlsMapper urlsMapper;
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
        return urlsMapper.findList(pages, params);
    }
}
