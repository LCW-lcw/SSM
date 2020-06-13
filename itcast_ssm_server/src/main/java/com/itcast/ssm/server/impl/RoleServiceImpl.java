package com.itcast.ssm.server.impl;

import com.itcast.ssm.dao.IRoleDao;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.server.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception {

       return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }
}
