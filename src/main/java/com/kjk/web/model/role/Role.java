package com.kjk.web.model.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjk.web.model.generic.BaseEntity;
import com.kjk.web.model.user.User;
import com.kjk.web.type.UserRoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tbl_role")
public class Role extends BaseEntity {
    private UserRoleType roleName;

    @OneToOne(mappedBy = "role", fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Role() {
    }

    public Role(Long id) {
        this.setId(id);
    }
}
