package com.itcast.ssm.server.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.IOrdersDao;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.server.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
//        pageNum页码值，pageSize:每一页几条信息，（必须写在真正调用分页代码的时候）
        PageHelper.startPage(page,size);
        return  iOrdersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return iOrdersDao.findById(ordersId);
    }
}
