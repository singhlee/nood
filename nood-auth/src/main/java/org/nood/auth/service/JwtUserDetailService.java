package org.nood.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.nood.auth.entity.SysRole;
import org.nood.auth.entity.SysUser;
import org.nood.auth.repository.SysUserDao;
import org.nood.auth.utils.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Service
@Slf4j
public class JwtUserDetailService implements UserDetailsService {
    private SysUserDao sysUserDao;
    /**
     * @Author: zengzr
     * @Date: 2019/3/29
     * @Description: 查询缓存
     * @Cacheable 缓存
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = null;
        List<SysRole> roleList=new ArrayList<>();
        try {
             sysUser = sysUserDao.findSysUserByUserName(username);
            if(sysUser == null){
                //仍需要细化处理
                throw new UsernameNotFoundException("该用户不存在");
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new UsernameNotFoundException("该用户不存在");
        }
        return  new JwtUserDetails(sysUser.getId(),sysUser.getUserName(),sysUser.getPassword(), sysUser.getRoles());
    }

    @Autowired
    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }
}
