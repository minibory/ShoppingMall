package com.kjk.web.Repository;

import static com.kjk.web.model.QUser.user;
import com.kjk.web.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JPAQueryFactory queryFactory;

    public List<User> findById(String id) {
        return queryFactory.selectFrom(user)
                .where(user.loginId.eq(id))
                .fetch();
    }
}
