package com.hbq.cms.config;

import com.hbq.cms.common.model.ErrorEnum;
import com.hbq.cms.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author: hbq
 * @description: 统一异常拦截
 * @date: 2017/10/24 10:31
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
	/**
	 * 参数校验异常处理
	 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.error("校验失败：{}\nat：{}", e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(",", "\n   "));
        String message = e.getFieldError().getDefaultMessage();
        String errorDetail = message + "(" + e.getFieldError().getField() + ")";
        return Result.failed(errorDetail);
    }

    /**
     * 常规异常处理
     */
    @ExceptionHandler(Throwable.class)
    public Result handleGeneralException(Exception e) {
        log.error("未知异常：{}\nat：{}", e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(",", "\n   "));
        return Result.failedWith("", ErrorEnum.E_500.getErrorCode(), ErrorEnum.E_500.getErrorMsg());
    }
}
