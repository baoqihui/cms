package com.hbq.cms.mapper;

import com.hbq.cms.model.Media;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 媒体
 * 
 * @author hbq
 * @date 2022-03-26 19:40:25
 */
@Mapper
public interface MediaMapper extends SuperMapper<Media> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
