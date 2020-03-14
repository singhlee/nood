package org.nood.repository;

import org.nood.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Repository
public interface SysRoleDao extends JpaRepository<SysRole,Integer> {
}
