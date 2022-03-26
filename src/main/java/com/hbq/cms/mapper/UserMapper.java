package com.hbq.cms.mapper;

import com.hbq.cms.model.User;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 用户表
 * 
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
@Mapper
public interface UserMapper extends SuperMapper<User> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
