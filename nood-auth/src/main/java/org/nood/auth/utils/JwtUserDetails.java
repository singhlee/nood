package org.nood.auth.utils;

import lombok.Data;
import org.nood.auth.entity.SysRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Data
public class JwtUserDetails implements UserDetails {

    private Integer userId;
    private String username;

    private String password;

    private List<SysRole> authorities;

    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;

    public JwtUserDetails(Integer userId, String username, String password, List<SysRole> authorities){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysRole sysRole : authorities){
            GrantedAuthority authority = new SimpleGrantedAuthority(sysRole.getId().toString());
            grantedAuthorities.add(authority);
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   public List<SysRole> getSysRols(){
        return this.authorities;
   }
}
