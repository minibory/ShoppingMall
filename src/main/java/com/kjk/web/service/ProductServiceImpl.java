package com.kjk.web.service;

import com.kjk.web.Repository.ProductRepository;
import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;
import com.kjk.web.model.role.Role;
import com.kjk.web.model.user.User;
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

    @Override
    public void save(Product user) {
        productRepository.save(user);
    }
}
