package org.nood.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ProjectName: nood
 * @Package: org.nood.entity
 * @ClassName: SysUserRole
 * @Author: LX
 * @Description:
 * @Date: 2019/7/29 15:29
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String remark;

    private Byte delFlag;
}
