package com.kjk.web.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjk.web.model.generic.BaseEntity;
import com.kjk.web.model.role.Role;
import com.kjk.web.model.product.Product;
import com.kjk.web.type.UserRoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "SeqGenerator", sequenceName = "SEQ_USER_ID", allocationSize = 1)
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor
@Transactional
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -6829693587200493915L;

    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @Column
    private String password;

    @Column(length = 1)
    private boolean active = true;

    @Column(length = 50)
    private String nickname;

    @Column
    private String address;

    @Column(length = 12)
    private String telNo;

//    @Transient
//    private String auth;

    @OneToOne
    @JoinTable(
            name = "tbl_user_role",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Role role;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_user_product",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products = new ArrayList<>();
}
