package org.nood.auth.entity;

import lombok.Data;

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

    @ManyToMany(mappedBy = "menus")
    private List<SysRole> roles = new ArrayList<>();



}
