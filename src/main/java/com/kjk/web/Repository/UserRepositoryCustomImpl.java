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

    /**
     * username(로그인 ID) 비교
     */
    private BooleanExpression eqUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        return user.username.eq(username);
    }

    @Override
    public List<User> findByUsername(String username) {
        return jpaQueryFactory
                .selectFrom(user)
                .where(eqUsername(username))
                .fetch();
    }

    @Override
    public Long usernameValidate(String username) {
        return jpaQueryFactory
                .select(user.count())
                .from(user)
                .where(eqUsername(username))
                .fetchOne();
    }

    @Override
    public Long getUserId(String username) {
        return jpaQueryFactory
                .select(user.Id)
                .from(user)
                .where(eqUsername(username))
                .fetchOne();
    }
}
