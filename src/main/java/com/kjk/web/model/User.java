package com.kjk.web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@SequenceGenerator(name = "SeqGenerator", sequenceName = "SEQ_USER_ID", allocationSize = 1)
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -6829693587200493915L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long Id;

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

    @OneToMany
    private List<Product> products = new ArrayList<>();

//    @Transient
//    private String auth;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_user_role",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Role role = new Role();

}
