package com.kjk.web.controller.rest;

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
    public ResultEntity<List<Product>> getProductList(ProductVO productVO) {

        List<Product> productList = productService.getProductList(productVO);

        return new ResultEntity<>("1", productList);
    }
}
