package com.itcast.ssm.server;

import com.itcast.ssm.domain.Product;

import java.util.List;

public interface IProductServer {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
