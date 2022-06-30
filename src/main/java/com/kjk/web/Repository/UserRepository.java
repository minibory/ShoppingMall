package com.kjk.web.Repository;

import static com.kjk.web.model.QUser.user;

import com.kjk.web.model.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JPAQueryFactory queryFactory;

    public List<User> findById(String loginId) {
        return queryFactory
                .selectFrom(user)
                .where(eqLoginId(loginId))
                .fetch();
    }

    private BooleanExpression eqLoginId(String loginId) {
        if(StringUtils.isEmpty(loginId)) {
            return null;
        }
        return user.loginId.eq(loginId);
    }
}
