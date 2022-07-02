package com.kjk.web.Repository;

import com.kjk.web.model.user.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static com.kjk.web.model.user.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> findByUsername(String username) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(eqUsername(username))
                .fetch();
    }

    private BooleanExpression eqUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        return user.username.eq(username);
    }
}
