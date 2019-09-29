package com.imooc.gulixueyuan.ucenter.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.gulixueyuan.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.gulixueyuan.ucenter.entity.query.QueryMember;

/**
 * <p>
 * 学员表 服务类
 * </p>
 *
 * @author kk
 * @since 2019-09-26
 */
public interface MemberService extends IService<Member> {

    void pageQuery(Page<Member> pageParam, QueryMember searchObj);
}
