package org.nood.auth.repository;

import org.nood.auth.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@Repository
public interface SysRoleDao extends JpaRepository<SysRole,Integer> {
    List<SysRole> findAllById(Integer id);
}
