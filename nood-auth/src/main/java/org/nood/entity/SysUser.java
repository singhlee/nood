package org.nood.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ProjectName: nood
 * @Package: org.nood.entity
 * @ClassName: user
 * @Author: LX
 * @Description:
 * @Date: 2019/7/29 15:27
 * @Version: 1.0
 */
@Entity
@Setter
@Getter
public class SysUser implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private String deptName;

    private Byte delFlag;

    private String roleNames;


    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysRole> roles;

    // 下面为实现UserDetails而需要的重写方法！

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole  role : roles) {
            authorities.add( new SimpleGrantedAuthority( role.getName() ) );
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return name;
    }



}
