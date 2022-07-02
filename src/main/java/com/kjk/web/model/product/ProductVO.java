package com.kjk.web.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {

    // 상품 세일 유무
    private boolean productSaleYn;

    // 상품 소유자 ID(loginId)
    private String username;
}
