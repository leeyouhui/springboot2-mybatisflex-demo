package com.bruce.demo.common.entity;

import lombok.Data;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 响应结果
 */
@Data
public class Result<T> {
    private T obj;
    private Integer code;
    private String message;
    private String requestId;

}
