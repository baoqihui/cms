package com.hbq.cms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.dto.MediaDto;
import com.hbq.cms.mapper.MediaMapper;
import com.hbq.cms.model.Media;
import com.hbq.cms.service.IMediaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 媒体
 *
 * @author hbq
 * @date 2022-03-26 19:40:25
 */
@Slf4j
@Service
@AllArgsConstructor
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media> implements IMediaService {
    private MediaMapper mediaMapper;
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
        return mediaMapper.findList(pages, params);
    }

    @Override
    public Result share(MediaDto mediaDto) {
        Media media = BeanUtil.copyProperties(mediaDto, Media.class);
        boolean b = this.saveOrUpdate(media);
        if (!b){
            return Result.failed("分享失败");
        }
        return Result.succeed(media,"分享成功");
    }
}
