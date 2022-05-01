package com.hbq.cms.mapper;

import com.hbq.cms.model.Clock;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 打卡
 * 
 * @author hbq
 * @date 2022-05-01 09:28:40
 */
@Mapper
public interface ClockMapper extends SuperMapper<Clock> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
