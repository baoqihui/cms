package com.hbq.cms.filter;

import cn.hutool.core.util.ObjectUtil;
import com.google.gson.Gson;
import com.hbq.cms.common.model.ErrorEnum;
import com.hbq.cms.common.model.RedisKey;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.common.model.SysConst;
import com.hbq.cms.model.User;
import com.hbq.cms.util.RedisUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author XiaoHui
 */
@Component
@AllArgsConstructor
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    private RedisUtils redisUtils;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        log.info("request url : {} 进行用户拦截校验", request.getRequestURL().toString());
        //redis里获取缓存用户
        String jsonUser = redisUtils.get(String.format(RedisKey.USER_KEY, request.getHeader(SysConst.USER_TOKEN)));
        User user = new Gson().fromJson(jsonUser, User.class);
        if (ObjectUtil.isNotEmpty(user)) {
            log.info("user:{}放行", user.getName());
            return true;
        }
        log.info("拦截");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().print(new Gson().toJson(Result.failed(ErrorEnum.E_202.getErrorMsg())));
        return false;
    }
}

