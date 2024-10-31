package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodLike is a Querydsl query type for FoodLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodLike extends EntityPathBase<FoodLike> {

    private static final long serialVersionUID = 414000577L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodLike foodLike = new QFoodLike("foodLike");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QFoodLike(String variable) {
        this(FoodLike.class, forVariable(variable), INITS);
    }

    public QFoodLike(Path<? extends FoodLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodLike(PathMetadata metadata, PathInits inits) {
        this(FoodLike.class, metadata, inits);
    }

    public QFoodLike(Class<? extends FoodLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

