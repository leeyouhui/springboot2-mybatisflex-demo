package com.bruce.demo.common.exception;

import com.bruce.demo.common.entity.Result;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 解决 @Valid 注解效验返回值问题
 */
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 此方法只处理 含有 @Valid 注解的请求
     *
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers, final HttpStatus status,
                                                                  final WebRequest request) {
        return new ResponseEntity<>(getError(ex.getBindingResult().getAllErrors()), status);

    }

    /**
     * 返回结果
     *
     * @param allErrors
     * @returnR
     */
    private Result<Object> getError(final List<ObjectError> allErrors) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMessage(allErrors.get(0).getDefaultMessage());
        result.setRequestId(MDC.get("traceId"));
        return result;
    }
}