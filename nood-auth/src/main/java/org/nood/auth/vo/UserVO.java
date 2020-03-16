package org.nood.auth.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-16 10:24
 **/
@Data
public class UserVO  implements Serializable {

    private Integer id;
    private String userName;
    private String password;
    private String avatar;
//    private List<RoleVO> roles = new ArrayList<>();
}
