package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.*;
import com.caler.zkl.openpsd.service.MemberService;
import com.caler.zkl.openpsd.util.LoggingUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private RoleMemberRelationMapper roleMemberRelationMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public int create(Member member) {
        member.setCreateTime(new Date());
        member.setStatus(1);
        member.setMemberLevelId(2L);
        member.setPassword(BCrypt.hashpw(member.getPassword(), BCrypt.gensalt()));
        int count = memberMapper.insertSelective(member);
        //添加用户后给用户赋值默认角色
        RoleMemberRelation roleMemberRelation = new RoleMemberRelation();
        roleMemberRelation.setRoleId(12L);
        roleMemberRelation.setResourceId(member.getId());
        roleMemberRelationMapper.insertSelective(roleMemberRelation);
        return count;
    }

    @Override
    public int update(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            count += memberMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public Member list(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Member selectByName(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> members = memberMapper.selectByExample(example);
        if (members.size() > 0) {
            return members.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Boolean checkByName(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> members = memberMapper.selectByExample(example);
        return members.size() > 0;
    }

    @Override
    public List<Member> list() {
        return memberMapper.selectByExample(null);
    }

    @Override
    public List<Member> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MemberExample example = new MemberExample();
        if (keyword != null) {
            example.createCriteria().andUsernameLike("%" + keyword + "%");
            example.or().andNicknameLike("%" + keyword + "%");
        }
        //设置条件
        return memberMapper.selectByExample(example);
    }

    @Override
    public List<Member> list(Member record, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MemberExample example = new MemberExample();
        //设置条件
        memberMapper.updateByExampleSelective(record, example);
        return memberMapper.selectByExample(example);
    }

    @Override
    public int allocRole(Long memberId, List<Long> roleIds) {
        AtomicInteger count = new AtomicInteger();
        //先删除后添加
        RoleMemberRelationExample example = new RoleMemberRelationExample();
        example.createCriteria().andResourceIdEqualTo(memberId);
        roleMemberRelationMapper.deleteByExample(example);

        roleIds.forEach(item -> {
            RoleMemberRelation roleMemberRelation = new RoleMemberRelation();
            roleMemberRelation.setResourceId(memberId);
            roleMemberRelation.setRoleId(item);
            count.addAndGet(roleMemberRelationMapper.insertSelective(roleMemberRelation));
        });
        return count.get();
    }

    @Override
    public List<Role> getRoleByMemberId(Long memberId) {
        return memberDao.selectRoleByMemberId(memberId);
    }

    @Override
    public int updateLastLoginTime(String username) {
        Member member = new Member();
        member.setLastLoginTime(new Date());
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        return memberMapper.updateByExampleSelective(member, example);
    }
}
