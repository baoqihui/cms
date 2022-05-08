package com.hbq.cms.mapper;

import com.hbq.cms.model.Medicals;
import com.hbq.cms.common.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 医疗内容
 * 
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
@Mapper
public interface MedicalsMapper extends SuperMapper<Medicals> {
    /**
     * 分页查询用户列表
     * @param pages
     * @param params
     * @return
     */
    Page<Map> findList(Page<Map> pages, @Param("p") Map<String, Object> params);
}
