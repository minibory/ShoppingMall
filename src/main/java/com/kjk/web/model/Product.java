package com.kjk.web.model;

import com.kjk.web.model.generic.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "SeqGenerator", sequenceName = "SEQ_PRODUCT_ID", allocationSize = 1)
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {
    private static final long serialVersionUID = -2453764726791752817L;

    @Column(length = 100, unique = true, nullable = false)
    private String productName;

    @Column
    private int productStock;

    @Column
    private int productPrice;

    @Column
    private String productImg;
}
