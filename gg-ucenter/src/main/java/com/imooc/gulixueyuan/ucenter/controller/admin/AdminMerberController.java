package com.imooc.gulixueyuan.ucenter.controller.admin;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.gulixueyuan.common.entity.PageResult;
import com.imooc.gulixueyuan.common.entity.R;
import com.imooc.gulixueyuan.ucenter.entity.Member;
import com.imooc.gulixueyuan.ucenter.entity.query.QueryMember;
import com.imooc.gulixueyuan.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("学员管理")
@RestController
@RequestMapping("/admin/ucenter/member")
public class AdminMerberController {
    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "所有学员列表")
    @GetMapping("/list")
    public R getList() {
        List<Member> list = memberService.list(null);
        return R.ok().data(list);
    }

    @ApiOperation(value = "根据ID删除学员")
    @DeleteMapping("/{memberId}")
    public R deleteById(
            @ApiParam(name = "memberId", value = "学员ID", required = true)
            @PathVariable Long memberId) {
        memberService.removeById(memberId);
        return R.ok();

    }

    @ApiOperation(value = "分页学员列表")
    @PostMapping(value = "{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "searchMap", value = "查询对象", required = false)
            @RequestBody QueryMember searchObj
    ) {
        Page<Member> pageParam = new Page(page, limit);
        memberService.pageQuery(pageParam, searchObj);
        long total = pageParam.getTotal();
        List<Member> records = pageParam.getRecords();
        PageResult<Member> result = new PageResult<>(total, records);
        return R.ok().data(result);

    }
}
