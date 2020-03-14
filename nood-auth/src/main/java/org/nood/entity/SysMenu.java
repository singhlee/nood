package org.nood.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Entity
@Table(name = "sys_menu")
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id",length = 10)
    private Integer id;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_url")
    private String menuUrl;

    @ManyToMany(mappedBy = "menus" ,fetch = FetchType.EAGER)
    private Set<SysRole> roles = new HashSet<>(0);



}
