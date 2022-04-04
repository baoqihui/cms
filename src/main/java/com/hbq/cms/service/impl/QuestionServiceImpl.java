package com.hbq.cms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.mapper.QuestionMapper;
import com.hbq.cms.mapper.ReplyMapper;
import com.hbq.cms.model.Question;
import com.hbq.cms.model.Reply;
import com.hbq.cms.service.IQuestionService;
import com.hbq.cms.vo.QuestionVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    private ReplyMapper replyMapper;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    public Page<Map> findList(Map<String, Object> params) {
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

    @Override
    public Result findDetailById(Long id) {
        Question question = questionMapper.selectById(id);
        if (ObjectUtil.isNull(question)) {
            return Result.failed("问题不存在");
        }
        List<Reply> replies = replyMapper.selectList(new LambdaQueryWrapper<Reply>()
                .eq(Reply::getQuestionId, id));
        QuestionVo questionVo = BeanUtil.copyProperties(question, QuestionVo.class);
        questionVo.setReplies(replies);
        return Result.succeed(questionVo);
    }
}
