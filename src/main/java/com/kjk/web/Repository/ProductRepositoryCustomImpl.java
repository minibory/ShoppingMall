package com.kjk.web.Repository;

import com.kjk.web.model.product.Product;
import com.kjk.web.model.product.ProductVO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static com.kjk.web.model.product.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> findByList(ProductVO productVO) {
        return jpaQueryFactory
                .selectFrom(product)
                .where(eqProductSaleYn(productVO.isProductSaleYn()),
                        eqUsername(productVO.getUsername()))
                .fetch();
    }

    private BooleanExpression eqProductSaleYn(boolean productSaleYn) {
        if(ObjectUtils.isEmpty(productSaleYn)) {
            return null;
        }
        return product.productSaleYn.eq(productSaleYn);
    }

    private BooleanExpression eqUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        return product.user.username.eq(username);
    }
}
