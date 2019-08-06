package org.nood.repository;

import org.nood.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: nood
 * @Package: org.nood.repository
 * @ClassName: UserRepository
 * @Author: LX
 * @Description:
 * @Date: 2019/7/29 15:57
 * @Version: 1.0
 */
public interface UserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByName( String name );
}
