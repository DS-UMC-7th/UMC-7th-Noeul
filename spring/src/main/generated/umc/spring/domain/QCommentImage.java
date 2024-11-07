package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentImage is a Querydsl query type for CommentImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentImage extends EntityPathBase<CommentImage> {

    private static final long serialVersionUID = -2139943704L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentImage commentImage = new QCommentImage("commentImage");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final QComment comment;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCommentImage(String variable) {
        this(CommentImage.class, forVariable(variable), INITS);
    }

    public QCommentImage(Path<? extends CommentImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentImage(PathMetadata metadata, PathInits inits) {
        this(CommentImage.class, metadata, inits);
    }

    public QCommentImage(Class<? extends CommentImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new QComment(forProperty("comment"), inits.get("comment")) : null;
    }

}

