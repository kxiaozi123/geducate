package com.imooc.gulixueyuan.ucenter.controller;


import com.imooc.gulixueyuan.common.entity.R;
import com.imooc.gulixueyuan.ucenter.entity.Member;
import com.imooc.gulixueyuan.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学员表 前端控制器
 * </p>
 *
 * @author kk
 * @since 2019-09-26
 */
@Api("学员管理")//对api资源的描述（热部署不好使）
@RestController
@RequestMapping("/ucenter/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "添加学员",notes = "memberId，createTime，deleted自动生成，无需添加")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "member", value = "学员对象json", required = true)
            @RequestBody Member member)
    {
         memberService.save(member);
         return R.ok();
    }

}

