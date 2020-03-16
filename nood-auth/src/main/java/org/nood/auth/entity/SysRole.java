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
@Table(name = "sys_role")
@Setter
@Getter
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",length = 20)
    private Integer id;
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<SysUser> users = new ArrayList<>();

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "sys_role_menu",
            joinColumns = @JoinColumn(name="role_id",referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id",referencedColumnName="id"))
    private List<SysMenu> menus = new ArrayList<>();


}
