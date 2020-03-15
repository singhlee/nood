package org.nood.service;

import org.nood.entity.SysUser;

public interface UserService {

    SysUser findByName(String username);
}
