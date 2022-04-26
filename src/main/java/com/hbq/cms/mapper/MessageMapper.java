package com.hbq.cms.mapper;

import com.hbq.cms.model.Message;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 消息/汇报
 * 
 * @author hbq
 * @date 2022-04-26 18:21:26
 */
@Mapper
public interface MessageMapper extends SuperMapper<Message> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
