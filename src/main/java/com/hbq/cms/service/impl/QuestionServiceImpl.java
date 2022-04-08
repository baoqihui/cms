package com.hbq.cms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
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
import com.hbq.cms.model.User;
import com.hbq.cms.service.IQuestionService;
import com.hbq.cms.service.IUserService;
import com.hbq.cms.vo.QuestionVo;
import com.hbq.cms.vo.ReplyVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private IUserService userService;
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
        QuestionVo questionVo = BeanUtil.copyProperties(question, QuestionVo.class);
        List<Reply> replies = replyMapper.selectList(new LambdaQueryWrapper<Reply>()
                .eq(Reply::getQuestionId, id));
        List<ReplyVo> replyVos = replies.stream().map(reply -> {
            User user = userService.getById(reply.getReplyUserId());
            ReplyVo replyVo = BeanUtil.copyProperties(reply, ReplyVo.class);
            replyVo.setReplyName(user.getName());
            return replyVo;
        }).collect(Collectors.toList());
        questionVo.setReplies(replyVos);
        return Result.succeed(questionVo);
    }

    @Override
    public Result delete(Long id) {
        Question question = questionMapper.selectById(id);
        if (ObjectUtil.isNull(question)) {
            return Result.failed("问题不存在");
        }
        List<Reply> replies = replyMapper.selectList(new LambdaQueryWrapper<Reply>()
                .eq(Reply::getQuestionId, id));
        if (CollUtil.isNotEmpty(replies)) {
            return Result.failed("该问题下有回复，不能删除");
        }
        questionMapper.deleteById(id);
        return Result.succeed("删除成功");
    }
}
