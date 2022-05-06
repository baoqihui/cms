package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.BannerMapper;
import com.hbq.cms.service.IBannerService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Banner;

/**
 * 公告
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Slf4j
@Service
@AllArgsConstructor
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {
    private BannerMapper bannerMapper;
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
        return bannerMapper.findList(pages, params);
    }
}
