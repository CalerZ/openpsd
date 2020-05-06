package com.caler.zkl.openpsd.service;


import com.caler.zkl.openpsd.bean.Member;
import com.caler.zkl.openpsd.bean.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台角色管理Service
 * Created by macro on 2018/9/30.
 */
public interface MemberService {
    /**
     * 添加
     */
    int create(Member member);

    /**
     * 修改
     */
    int update(Member member);

    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 查询单个
     */
    Member list(Long id);

    /**
     * 根据用户名查询用户
     */
    Member selectByName(String username);

    /**
     * 检查用户名是否唯一
     */
    Boolean checkByName(String username);

    /**
     * 查询所有
     */
    List<Member> list();

    List<Member> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 条件分页查询
     */
    List<Member> list(Member member, Integer pageSize, Integer pageNum);

    /**
     * 给用户分配角色
     * @param memberId
     * @param roleIds
     * @return
     */
    int allocRole(Long memberId, List<Long> roleIds);

    List<Role> getRoleByMemberId(Long memberId);


    /**
     * 更新最后登录时间
     * @param username
     * @return
     */
    int updateLastLoginTime(String username);
}
