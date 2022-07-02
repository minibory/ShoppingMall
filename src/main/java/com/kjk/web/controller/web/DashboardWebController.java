package com.kjk.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/product"})
public class DashboardWebController {

    @GetMapping
    public String allProducts() {
        return "productList";
    }

    @GetMapping("/sale")
    public ModelAndView saleProducts() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("category", "sale");

        mv.setViewName("productList");
        return mv;
    }

    @GetMapping("/my")
    public ModelAndView myProducts() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("category", "my");

        mv.setViewName("productList");
        return mv;
    }
}
