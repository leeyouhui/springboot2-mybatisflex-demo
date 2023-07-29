package com.bruce.demo.my.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author bruce
 * @since 2023-06-05
 */
@Data
@ApiModel(value = "User对象", description = "用户表")
@Table(value = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @Id(value = "id", keyType = KeyType.Auto)
    private Long id;

    @ApiModelProperty("微信用户ID")
    private String wechatUserId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像地址")
    private String avatarUrl;

    @ApiModelProperty("性别，0-未知，1-男性，2-女性")
    private Integer gender;

    @ApiModelProperty("所在国家")
    private String country;

    @ApiModelProperty("所在省份")
    private String province;

    @ApiModelProperty("所在城市")
    private String city;

    @ApiModelProperty("所用语言")
    private String language;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新人")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private Date updateTime;


}
