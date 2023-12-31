package com.bruce.demo.test.entity.po;

import com.bruce.demo.common.entity.BasePo;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(value = "tb_account")
public class Account extends BasePo implements Serializable {
    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
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
