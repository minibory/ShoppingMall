package com.kjk.web.controller.web;

import com.kjk.web.model.product.Product;
import com.kjk.web.model.user.User;
import com.kjk.web.service.ProductService;
import com.kjk.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/product"})
@RequiredArgsConstructor
public class ProductWebController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping
    public String allProductList() {
        return "/product/productList";
    }

    @GetMapping("/sale")
    public ModelAndView saleProductList() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("category", "sale");

        mv.setViewName("/product/productList");
        return mv;
    }

    @GetMapping("/my")
    public ModelAndView myProductList() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("category", "my");

        mv.setViewName("/product/productList");
        return mv;
    }

    @GetMapping("/add-form")
    public String addProductPage() {

        return "/product/productAdd";
    }

    @PostMapping("/add")
    public String addProduct(Product product, Authentication authentication) {
        // username으로 User가져와서 Product에 set할 예정
        // 화면단에서 productImg가 넘어오는 지! (나머지는 굳)
        User user = userService.findByUsername(authentication.getName()).get(0);

        product.setUser(user);
        productService.save(product);

        return "handler/product/addSuccess";
    }
}
