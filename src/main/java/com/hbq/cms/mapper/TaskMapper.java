package com.hbq.cms.mapper;

import com.hbq.cms.model.Task;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 任务
 * 
 * @author hbq
 * @date 2022-04-04 14:39:49
 */
@Mapper
public interface TaskMapper extends SuperMapper<Task> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
