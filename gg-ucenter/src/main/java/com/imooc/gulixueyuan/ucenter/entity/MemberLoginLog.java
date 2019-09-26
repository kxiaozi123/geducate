package com.imooc.gulixueyuan.ucenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学员登录日志表
 * </p>
 *
 * @author kk
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ucenter_member_login_log")
@ApiModel(value="MemberLoginLog对象", description="学员登录日志表")
public class MemberLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志ID")
    @TableId("LOG_ID")
    private Long logId;

    @ApiModelProperty(value = "登录时间")
    @TableField("LOGIN_TIME")
    private Date loginTime;

    @ApiModelProperty(value = "登录IP")
    @TableField("IP")
    private String ip;

    @ApiModelProperty(value = "用户ID")
    @TableField("MEMBER_ID")
    private Long memberId;

    @ApiModelProperty(value = "操作系统")
    @TableField("OS_NAME")
    private String osName;

    @ApiModelProperty(value = "浏览器")
    @TableField("USER_AGENT")
    private String userAgent;


}
