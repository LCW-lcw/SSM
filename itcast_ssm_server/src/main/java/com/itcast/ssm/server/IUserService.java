package com.itcast.ssm.server;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService  extends UserDetailsService {


    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo);

    UserInfo findById(String id);


    void addRoleToUser(String userId, String[] roleIds);

    List<Role> findOtherRoles(String userid);
}
