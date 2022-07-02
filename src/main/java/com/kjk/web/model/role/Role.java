package com.kjk.web.model.role;

import com.kjk.web.model.generic.BaseEntity;
import com.kjk.web.model.user.User;
import com.kjk.web.type.UserRoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tbl_role")
public class Role extends BaseEntity {
    private UserRoleType roleName = UserRoleType.USER;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> users;

}
