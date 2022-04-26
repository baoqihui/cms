package com.hbq.cms.service.impl;
import com.hbq.cms.mapper.MessageMapper;
import com.hbq.cms.service.IMessageService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import java.util.Map;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Message;

/**
 * 消息/汇报
 *
 * @author hbq
 * @date 2022-04-26 18:21:26
 */
@Slf4j
@Service
@AllArgsConstructor
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
    private MessageMapper messageMapper;
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
        return messageMapper.findList(pages, params);
    }
}
