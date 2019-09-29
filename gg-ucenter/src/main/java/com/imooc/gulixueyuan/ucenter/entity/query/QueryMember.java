package com.imooc.gulixueyuan.ucenter.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Member查询对象", description = "会员查询对象封装")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class QueryMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "邮箱/手机/昵称/姓名,模糊查询")
    private String keyWord;
    @ApiModelProperty(value = "是否可用：1正常，2冻结")
    private Boolean isAvailable;
    @ApiModelProperty(value = "查询开始时间", example = "2018-01-01 10:10:10")
    private Date begin;
    @ApiModelProperty(value = "查询结束时间", example = "2018-12-01 10:10:10")
    private Date end;
}
