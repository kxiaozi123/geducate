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
 * 学员表
 * </p>
 *
 * @author kk
 * @since 2019-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ucenter_member")
@ApiModel(value="Member对象", description="学员表")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学员ID")
    @TableId("MEMBER_ID")
    private Long memberId;

    @ApiModelProperty(value = "手机号")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "邮箱号")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "用户名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "显示名 （昵称）")
    @TableField("SHOW_NAME")
    private String showName;

    @ApiModelProperty(value = "性别  1男  0女")
    @TableField("SEX")
    private Boolean sex;

    @ApiModelProperty(value = "年龄")
    @TableField("AGE")
    private Integer age;

    @ApiModelProperty(value = "是否可用 1正常  0冻结")
    @TableField("IS_AVAILABLE")
    private Boolean isAvailable;

    @ApiModelProperty(value = "用户头像")
    @TableField("PIC_IMG")
    private String picImg;

    @ApiModelProperty(value = "个人中心用户背景图片")
    @TableField("BANNER_URL")
    private String bannerUrl;

    @ApiModelProperty(value = "站内信未读消息数")
    @TableField("MSG_NUM")
    private Integer msgNum;

    @ApiModelProperty(value = "系统消息未读消息数")
    @TableField("SYS_MSG_NUM")
    private Integer sysMsgNum;

    @ApiModelProperty(value = "上传统计系统消息时间")
    @TableField("LAST_SYSTEM_TIME")
    private Date lastSystemTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    @ApiModelProperty(value = "注册时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    @ApiModelProperty(value = "逻辑删除 1已删除 0未删除")
    @TableField("DELETED")
    private Boolean deleted;


}
