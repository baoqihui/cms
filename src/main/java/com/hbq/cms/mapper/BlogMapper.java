package com.hbq.cms.mapper;

import com.hbq.cms.model.Blog;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 笔记
 * 
 * @author hbq
 * @date 2022-05-08 15:04:20
 */
@Mapper
public interface BlogMapper extends SuperMapper<Blog> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
