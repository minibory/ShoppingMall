package com.kjk.web.service;

import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;

import java.util.List;

public interface ProductService {

    List<Product> getProductList(ProductVO productVO);
}