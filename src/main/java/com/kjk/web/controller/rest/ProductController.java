package com.kjk.web.controller.rest;

import com.kjk.web.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/{category}/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


}
