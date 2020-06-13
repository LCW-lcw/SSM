package com.itcast.ssm.controller;

import com.itcast.ssm.domain.Product;
import com.itcast.ssm.server.IProductServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class IProductController {
    @Autowired
    private IProductServer iProductServer;

@RequestMapping("/save.do")
    public String save(Product product) throws Exception {
    iProductServer.save(product);
    return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = iProductServer.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }


}
