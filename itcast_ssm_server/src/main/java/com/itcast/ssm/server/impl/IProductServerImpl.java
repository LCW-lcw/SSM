package com.itcast.ssm.server.impl;

import com.itcast.ssm.dao.IProductDao;
import com.itcast.ssm.domain.Product;
import com.itcast.ssm.server.IProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProductServerImpl implements IProductServer {
    @Autowired
    private IProductDao iProductDao;
    @Override
    public List<Product> findAll() throws Exception{
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        iProductDao.save(product);
    }

}
