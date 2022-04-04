package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.QuestionMapper;
import com.hbq.cms.service.IQuestionService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Question;

/**
 * 问题
 *
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
@Slf4j
@Service
@AllArgsConstructor
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {
    private QuestionMapper questionMapper;
    /**
     * 列表
     * @param params
     * @return
     */
    public Page<Map> findList(Map<String, Object> params){
        Integer pageNum = MapUtil.getInt(params, "pageNum");
        Integer pageSize = MapUtil.getInt(params, "pageSize");
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = -1;
        }
        Page<Map> pages = new Page<>(pageNum, pageSize);
        return questionMapper.findList(pages, params);
    }
}
