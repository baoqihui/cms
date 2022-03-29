package com.hbq.cms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.dto.UserDto;
import com.hbq.cms.model.User;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户表
 *
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
public interface IUserService extends IService<User> {
    /**
     * 列表
     * @param params
     * @return
     */
    Page<Map> findList(Map<String, Object> params);

    Result<String> register(UserDto userDto);

    Result login(UserDto userDto, HttpServletResponse response);

    Result updatePwd(UserDto userDto);
}

