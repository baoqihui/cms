package com.hbq.cms.mapper;

import com.hbq.cms.model.Area;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 地区表
 * 
 * @author hbq
 * @date 2022-05-04 20:15:25
 */
@Mapper
public interface AreaMapper extends SuperMapper<Area> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
