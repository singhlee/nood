package org.nood.auth.repository;

import org.nood.auth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Repository
public interface SysUserDao extends JpaRepository<SysUser,Integer> {
    /**
     * 查询用户信息
     * @Author: singhlee
     * @Date: 2019/3/27
     * @param userName
     * @return SysUser
     */

    SysUser findSysUserByUserName(String userName);
}
