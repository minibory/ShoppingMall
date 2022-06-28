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
@SequenceGenerator(name = "SeqGenerator", sequenceName = "SEQ_USER_ID", allocationSize = 1)
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = -3678759275406100254L;

    @Column(length = 100, unique = true, nullable = false)
    private String userId;

    @Column
    private String password;

    @Column(length = 1)
    private boolean active = true;

    @Column(length = 50)
    private String username;


}
