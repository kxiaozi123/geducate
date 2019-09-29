package com.imooc.gulixueyuan.common.entity;

/**
 * @author helen
 * @since 2018/12/18
 */
public interface ResultCode {

    int OK = 20000; //成功
    int ERROR = 20001; //失败
    int LOGIN_ERROR = 20002; //登录错误
    int ACCESS_ERROR = 20003; //权限不足
    int REMOTE_ERROR = 20004; //远程调用失败
    int REPEAT_ERROR = 20005; //重复操作

}
