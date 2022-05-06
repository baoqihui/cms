package com.hbq.cms.mapper;

import com.hbq.cms.model.Trains;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 培训安排
 * 
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Mapper
public interface TrainsMapper extends SuperMapper<Trains> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
