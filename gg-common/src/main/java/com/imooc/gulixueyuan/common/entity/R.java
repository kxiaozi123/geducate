package com.imooc.gulixueyuan.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author helen
 * @since 2018/12/18
 */
@ApiModel( value = "全局返回结果")
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "消息")
    private  String message;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.OK);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R data(Object data){
        this.setData(data);
        return this;
    }


    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }
}
