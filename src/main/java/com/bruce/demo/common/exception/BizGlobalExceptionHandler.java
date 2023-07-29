package com.bruce.demo.common.exception;


import com.bruce.demo.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 全局业务异常处理
 */
@ControllerAdvice
@Slf4j
public class BizGlobalExceptionHandler {
    private boolean i18n = false;
    @Value("${sf-boot.mvc.app-exception-http-500:false}")
    private boolean bizExceptionHttp500;

    public void setI18n(boolean i18n) {
        this.i18n = i18n;
    }

    @ExceptionHandler({ApplicationException.class})
    @ResponseBody
    public Result<String> bizExceptionHandler(HttpServletRequest req, HttpServletResponse res, ApplicationException e) {
        log.info(e.getMessage());
        Result<String> result = new Result<>();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        // 国际化处理
        if (this.i18n) {
            result.setMessage(e.getMessage());
        }

        result.setRequestId(MDC.get("traceId"));
        if (this.bizExceptionHttp500) {
            res.setStatus(500);
        }

        return result;
    }

    /**
     * 捕获@valid验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<String> handleBindException(MethodArgumentNotValidException e) {
        log.info(e.getMessage());
        Result<String> result = new Result<>();
        result.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        result.setRequestId(MDC.get("traceId"));
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }
}
