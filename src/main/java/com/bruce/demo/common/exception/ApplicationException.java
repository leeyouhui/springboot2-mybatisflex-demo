package com.bruce.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 应用异常类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationException extends RuntimeException{
    private Integer code;
}
