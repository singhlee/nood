package org.nood.auth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Entity
@Table(name = "sys_user")
@Setter
@Getter
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",length = 20)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pwd")
    private String password;
    @Column(name = "avatar")
    private String avatar;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "sys_user_role",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName="id"))
    private List<SysRole> roles = new ArrayList<>();


}
