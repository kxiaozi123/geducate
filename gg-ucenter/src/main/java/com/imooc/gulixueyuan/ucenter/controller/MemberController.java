package com.imooc.gulixueyuan.ucenter.controller;


import com.imooc.gulixueyuan.ucenter.entity.Member;
import com.imooc.gulixueyuan.ucenter.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 学员表 前端控制器
 * </p>
 *
 * @author kk
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/ucenter/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/list")
    public List<Member>  getList()
    {
         return memberService.list(null);
    }

}

