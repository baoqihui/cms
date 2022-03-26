package com.hbq.cms.mapper;

import com.hbq.cms.model.Banner;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 轮播图
 *
 * @author hbq
 * @date 2022-03-26 19:53:05
 */
@Mapper
public interface BannerMapper extends SuperMapper<Banner> {
    /**
     * 分页查询用户列表
     *
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
