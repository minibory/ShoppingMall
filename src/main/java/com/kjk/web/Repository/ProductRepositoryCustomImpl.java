package com.kjk.web.Repository;

import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.kjk.web.model.product.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> findByList(ProductVO productVO) {
        if (!StringUtils.isEmpty(productVO.getUsername())) {
            return jpaQueryFactory
                    .selectFrom(product)
                    .where(eqProductSaleYn(productVO.isProductSaleYn()),
                            eqUsername(productVO.getUsername()))
                    .fetch();
        } else {
            List<Product> products = new ArrayList<>();
            return products;

        }
    }

    private BooleanExpression eqProductSaleYn(boolean productSaleYn) {
        if(productSaleYn) {
            return product.productSaleYn.eq(productSaleYn);
        } else {
            return null;
        }
    }

    private BooleanExpression eqUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        return product.user.username.eq(username);
    }
}
