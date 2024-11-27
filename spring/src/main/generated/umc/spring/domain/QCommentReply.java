package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommentReply is a Querydsl query type for CommentReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommentReply extends EntityPathBase<CommentReply> {

    private static final long serialVersionUID = -2131855753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommentReply commentReply = new QCommentReply("commentReply");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final QComment comment;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCommentReply(String variable) {
        this(CommentReply.class, forVariable(variable), INITS);
    }

    public QCommentReply(Path<? extends CommentReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommentReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommentReply(PathMetadata metadata, PathInits inits) {
        this(CommentReply.class, metadata, inits);
    }

    public QCommentReply(Class<? extends CommentReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comment = inits.isInitialized("comment") ? new QComment(forProperty("comment"), inits.get("comment")) : null;
    }

}

