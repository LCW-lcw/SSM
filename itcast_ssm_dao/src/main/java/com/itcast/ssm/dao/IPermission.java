package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermission {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId}) ")
    List<Permission> findByRoleId(String roleId) throws Exception;
}
