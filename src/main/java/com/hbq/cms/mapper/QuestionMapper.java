package com.hbq.cms.mapper;

import com.hbq.cms.model.Question;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 问题
 * 
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
@Mapper
public interface QuestionMapper extends SuperMapper<Question> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
