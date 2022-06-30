package com.kjk.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/menu", "/menu/product"})
public class DashboardWebController {

    @GetMapping
    public String allProduct() {
        return "productList";
    }
}
