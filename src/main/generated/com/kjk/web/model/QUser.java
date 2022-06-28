package com.kjk.web.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1390387001L;

    public static final QUser user = new QUser("user");

    public final com.kjk.web.model.generic.QBaseEntity _super = new com.kjk.web.model.generic.QBaseEntity(this);

    public final BooleanPath active = createBoolean("active");

    public final StringPath address = createString("address");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final StringPath telNo = createString("telNo");

    public final StringPath userId = createString("userId");

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

