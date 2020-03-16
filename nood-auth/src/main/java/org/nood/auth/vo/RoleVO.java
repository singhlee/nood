package org.nood.auth.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-16 10:30
 **/
public class RoleVO implements Serializable  {

    private Integer id;
    private String roleName;
    private List<MenuVO> menus = new ArrayList<>();
}
