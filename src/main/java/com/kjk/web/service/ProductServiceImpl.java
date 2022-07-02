package com.kjk.web.service;

import com.kjk.web.Repository.ProductRepository;
import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProductList(ProductVO productVO) {

        return productRepository.findByList(productVO);
    }
}
