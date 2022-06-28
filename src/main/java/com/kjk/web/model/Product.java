package com.kjk.web.model;

import com.kjk.web.model.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SeqGenerator", sequenceName = "SEQ_PRODUCT_ID", allocationSize = 1)
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {
    private static final long serialVersionUID = -2453764726791752817L;

    // 상품명
    @Column(length = 100, unique = true, nullable = false)
    private String productName;

    // 상품 재고
    @Column
    private int productStock;

    // 상품 정가
    @Column
    private int productPrice;

    // 이미지주소
    @Column
    private String productImg;

    // 상품 세일 유무
    @Column(length = 1)
    private boolean productSaleYn = false;

    // 상품 세일가
    @Column
    private int productSalePrice;

    // 상품 소유자
//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    private User user;
}