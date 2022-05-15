package com.hbq.cms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.mapper.VideoMapper;
import com.hbq.cms.model.Collect;
import com.hbq.cms.model.Reply;
import com.hbq.cms.model.User;
import com.hbq.cms.model.Video;
import com.hbq.cms.service.ICollectService;
import com.hbq.cms.service.IReplyService;
import com.hbq.cms.service.IUserService;
import com.hbq.cms.service.IVideoService;
import com.hbq.cms.vo.VideoVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 视频
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Slf4j
@Service
@AllArgsConstructor
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {
    private VideoMapper videoMapper;
    private IUserService userService;
    private IReplyService replyService;
    private ICollectService collectService;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
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
        return videoMapper.findList(pages, params);
    }

    @Override
    public Result getDetail(Long id, Long userId) {
        Video video = this.getById(id);
        if (ObjectUtil.isNull(video)||video.getStatus()==0) {
            return Result.failed("视频不存在或已下架");
        }
        User user = userService.getById(userId);
        if (ObjectUtil.isNull(user)) {
            return Result.failed("用户不存在");
        }
        if (ObjectUtil.equal(1, video.getIsVip()) && ObjectUtil.notEqual(1, user.getIsVip())) {
            return Result.failed("该视频为VIP视频，请先开通VIP");
        }
        video.setClickNum(video.getClickNum() + 1);
        updateById(video);
        int count = collectService.count(new LambdaQueryWrapper<Collect>()
                .eq(Collect::getUserId, userId)
                .eq(Collect::getVideoId, id)
                .eq(Collect::getIsCollect, 1));
        List<Reply> replies = replyService.list();
        VideoVO videoVO = BeanUtil.copyProperties(video, VideoVO.class);
        videoVO.setIsCollect(count > 0 ? 1 : 0);
        videoVO.setReplies(replies);
        return Result.succeed(videoVO, "查询成功");
    }
}
