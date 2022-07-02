package com.kjk.web.Repository;

import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findByList(ProductVO productVO);
}
