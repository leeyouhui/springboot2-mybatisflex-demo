package com.bruce.demo.test.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 账户表 实体类。
 *
 * @author lyh
 * @since 2023-07-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("账户表")
public class AccountVo implements Serializable {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Integer id;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String userName;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private LocalDateTime birthday;

}
