package org.nood.service.impl;

import org.nood.entity.SysUser;
import org.nood.repository.SysUserDao;
import org.nood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-15 17:27
 **/
@Service
public class UserServiceImpl implements UserService {


    SysUserDao sysUserDao;
    @Override
    public SysUser findByName(String username) {
        return sysUserDao.findSysUserByUserName(username);
    }

    @Autowired
    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }
}
