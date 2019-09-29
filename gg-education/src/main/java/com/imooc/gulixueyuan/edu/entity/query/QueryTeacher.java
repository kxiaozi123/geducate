package com.imooc.gulixueyuan.edu.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author helen
 * @since 2018/12/18
 */
@Data
@ApiModel(value ="Teacher查询对象")
public class QueryTeacher implements Serializable {

        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "讲师姓名")
        private String name;

        @ApiModelProperty(value = "讲师头衔")
        private Integer level;

        @ApiModelProperty(value = "注册开始时间", example = "2018-01-01 10:10:10")
        private Date begin;

        @ApiModelProperty(value = "注册结束时间", example = "2018-01-01 10:10:10")
        private Date end;

    }
