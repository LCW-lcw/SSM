package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

@Select("select productNum from product where productNum=#{pr}")
     Product findByp(String pr) throws Exception;

     @Insert("insert into product(productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) value(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
      void save(Product product);
     //查询所有的产品信息
     @Select("select * from product")
      List<Product> findAll() throws Exception;

}
