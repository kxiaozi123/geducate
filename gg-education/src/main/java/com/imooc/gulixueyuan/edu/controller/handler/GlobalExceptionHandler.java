package com.imooc.gulixueyuan.edu.controller.handler;

import com.imooc.gulixueyuan.common.entity.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author helen
 * @since 2018/12/19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){

        e.printStackTrace();
        return R.error();

    }


}
