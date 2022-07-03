package com.kjk.web.controller.rest;

import com.google.gson.Gson;
import com.kjk.web.model.generic.ResultEntity;
import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;
import com.kjk.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-management/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResultEntity getProductList(ProductVO productVO) {

        List<Product> productList = productService.getProductList(productVO);

        if(productList == null) {
            return new ResultEntity<>("0");
        }

        productList.stream().forEach(product -> product.setUser(null));

        return new ResultEntity<>("1", productList);
    }
}
