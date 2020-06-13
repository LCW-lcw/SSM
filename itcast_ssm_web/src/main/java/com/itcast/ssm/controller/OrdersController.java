package com.itcast.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.server.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue ="1")int page,@RequestParam(name="size",required = true,defaultValue = "4")int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> orders=iOrdersService.findAll(page,size);
//        PageInfo 就是一个分页的Bean
        PageInfo pageInfo=new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true)String ordersId) throws Exception {
        ModelAndView mv=new ModelAndView();
         Orders orders=iOrdersService.findById(ordersId);
         mv.addObject("orders",orders);
         mv.setViewName("orders-show");
        return mv;
    }

}
