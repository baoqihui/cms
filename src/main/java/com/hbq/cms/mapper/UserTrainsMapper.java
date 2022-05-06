package com.hbq.cms.mapper;

import com.hbq.cms.model.UserTrains;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 用户培训
 * 
 * @author hbq
 * @date 2022-05-06 11:49:32
 */
@Mapper
public interface UserTrainsMapper extends SuperMapper<UserTrains> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
