package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMarketImage is a Querydsl query type for MarketImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMarketImage extends EntityPathBase<MarketImage> {

    private static final long serialVersionUID = 586532435L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMarketImage marketImage = new QMarketImage("marketImage");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final QMarket market;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMarketImage(String variable) {
        this(MarketImage.class, forVariable(variable), INITS);
    }

    public QMarketImage(Path<? extends MarketImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMarketImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMarketImage(PathMetadata metadata, PathInits inits) {
        this(MarketImage.class, metadata, inits);
    }

    public QMarketImage(Class<? extends MarketImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.market = inits.isInitialized("market") ? new QMarket(forProperty("market"), inits.get("market")) : null;
    }

}

