package org.nood.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.nood.entity.SysUser;
import org.nood.repository.SysUserDao;
import org.nood.utils.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Service
@Slf4j
public class JwtUserDetailService implements UserDetailsService {
    @Autowired
    SysUserDao sysUserDao;
    /**
     * @Author: zengzr
     * @Date: 2019/3/29
     * @Description: 查询缓存
     * @Cacheable 缓存
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = null;

        try {
             sysUser = sysUserDao.findSysUserByUserName(userName);
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


}
