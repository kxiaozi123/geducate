package com.imooc.gulixueyuan.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.gulixueyuan.ucenter.entity.Member;
import com.imooc.gulixueyuan.ucenter.entity.query.QueryMember;
import com.imooc.gulixueyuan.ucenter.mapper.MemberMapper;
import com.imooc.gulixueyuan.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * <p>
 * 学员表 服务实现类
 * </p>
 *
 * @author kk
 * @since 2019-09-26
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public void pageQuery(Page<Member> pageParam, QueryMember searchObj) {
        Boolean isAvailable = searchObj.getIsAvailable();
        Date begin = searchObj.getBegin();
        Date end = searchObj.getEnd();
        String keyWord = searchObj.getKeyWord();
        QueryWrapper<Member> queryWrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(isAvailable))
        {
            queryWrapper.eq("IS_AVAILABLE",isAvailable);
        }
        if(!StringUtils.isEmpty(begin))
        {
            queryWrapper.ge("CREATE_TIME",begin);
        }
        if(!StringUtils.isEmpty(end))
        {
            queryWrapper.le("CREATE_TIME",end);
        }
        if(!StringUtils.isEmpty(keyWord))
        {
            //邮箱/手机/昵称/姓名
           queryWrapper.and(i->i.like("EMAIL", keyWord).or()
                                .like("MOBILE", keyWord).or()
                                .like("USER_NAME", keyWord).or()
                                .like("SHOW_NAME", keyWord));

        }
        baseMapper.selectPage(pageParam,queryWrapper);

    }
}
