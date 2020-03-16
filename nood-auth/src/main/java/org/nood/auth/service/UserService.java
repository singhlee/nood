package org.nood.auth.service;

import org.nood.auth.entity.SysUser;

public interface UserService {

    SysUser findByName(String username);
}
