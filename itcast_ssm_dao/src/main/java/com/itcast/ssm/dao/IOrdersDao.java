package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Member;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select="com.itcast.ssm.dao.IProductDao.findByp")),



    })
    List<Orders> findAll() throws Exception;

//    多表操作
@Select("select * from orders where orderNum=#{ordersId}")
@Results({
        @Result(id=true,property = "orderNum",column = "orderNum"),
        @Result(property = "orderTime",column = "orderTime"),
        @Result(property = "peopleCount",column = "peopleCount"),
        @Result(property = "orderStatus",column = "orderStatus"),
        @Result(property = "payType",column = "payType"),
        @Result(property = "orderDesc",column = "orderDesc"),
        @Result(property = "product",column = "productId",one = @One(select="com.itcast.ssm.dao.IProductDao.findByp")),
        @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select ="com.itcast.ssm.dao.IMemberDao.findById")),
        @Result(property = "travellers",column = "orderNum",javaType =java.util.List.class,many = @Many(select = "com.itcast.ssm.dao.ITraveller.findByOrdersId")),

})
    Orders findById(String ordersId) throws  Exception;
}
