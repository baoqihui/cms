package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.ReplyMapper;
import com.hbq.cms.service.IReplyService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Reply;

/**
 * 回复
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Slf4j
@Service
@AllArgsConstructor
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {
    private ReplyMapper replyMapper;
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
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
        return replyMapper.findList(pages, params);
    }
}
