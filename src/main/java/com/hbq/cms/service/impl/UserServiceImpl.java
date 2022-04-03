package com.hbq.cms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.hbq.cms.common.model.RedisKey;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.common.model.SysConst;
import com.hbq.cms.dto.UserDto;
import com.hbq.cms.mapper.UserMapper;
import com.hbq.cms.model.User;
import com.hbq.cms.service.IUserService;
import com.hbq.cms.util.RedisUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户表
 *
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private UserMapper userMapper;
    private RedisUtils redisUtils;

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
        return userMapper.findList(pages, params);
    }

    @Override
    public Result<String> register(UserDto userDto) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getAccount, userDto.getAccount()));
        if (ObjectUtil.isNotNull(user)) {
            return Result.failed("账号已存在");
        }
        User newUser = BeanUtil.copyProperties(userDto, User.class);
        //加密密码
        newUser.setPwd(SecureUtil.md5(userDto.getPwd()));
        boolean save = this.save(newUser);
        if (save) {
            return Result.succeed("注册成功");
        }
        return Result.failed("注册失败");
    }

    @Override
    public Result login(UserDto userDto, HttpServletResponse response) {
        User one = this.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getAccount, userDto.getAccount())
                .eq(User::getPwd, SecureUtil.md5(userDto.getPwd()))
        );
        if (ObjectUtil.isNull(one)) {
            return Result.failed("账号密码不匹配");
        }
        //生成随机token
        String userToken = IdUtil.randomUUID();
        //存入redis
        redisUtils.set(String.format(RedisKey.USER_KEY, userToken), new Gson().toJson(one), SysConst.USER_TIME_OUT);
        //存入response给前端
        response.addHeader(SysConst.USER_TOKEN, userToken);
        return Result.succeed(one, "登录成功");
    }

    @Override
    public Result updatePwd(UserDto userDto) {
        boolean update = this.update(new LambdaUpdateWrapper<User>()
                .eq(User::getAccount, userDto.getAccount())
                .set(User::getPwd, SecureUtil.md5(userDto.getPwd()))
        );
        if (!update) {
            return Result.failed("修改失败");
        }
        return Result.succeed("修改成功");
    }

    @Override
    public Result logout(HttpServletRequest request) {
        redisUtils.del(String.format(RedisKey.USER_KEY, request.getHeader(SysConst.USER_TOKEN)));
        return Result.succeed("退出成功");
    }
}
