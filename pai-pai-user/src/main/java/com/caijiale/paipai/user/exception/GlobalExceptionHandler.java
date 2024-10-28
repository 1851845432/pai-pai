package com.caijiale.paipai.user.exception;

import com.caijiale.paipai.base.response.BaseResponse;
import com.caijiale.paipai.commons.enums.BizErrorCodeEnum;
import com.caijiale.paipai.commons.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局异常处理器
 *
 * @author ruoyi
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({BizException.class})
    public BaseResponse handleBizException(BizException e, HttpServletRequest request) {
        log.error("请求地址'{}',业务异常'{}'", request.getRequestURI(), e.getMessage());
        return BaseResponse.fail(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder errorMessge = new StringBuilder();
        allErrors.forEach(error -> errorMessge.append(error.getDefaultMessage()).append(";"));
        log.error("请求地址'{}',参数校验异常'{}'", request.getRequestURI(), errorMessge);
        return BaseResponse.fail(BizErrorCodeEnum.PARAMETER_ERROR.getCode(), errorMessge.toString());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e, HttpServletRequest request) {
        log.error("请求地址'{}',系统未知异常'{}'", request.getRequestURI(), e.getMessage());
        return BaseResponse.fail(BizErrorCodeEnum.UNKNOWN.getCode(), BizErrorCodeEnum.UNKNOWN.getMessage());
    }
}
