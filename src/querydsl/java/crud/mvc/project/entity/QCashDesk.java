package crud.mvc.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCashDesk is a Querydsl query type for CashDesk
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCashDesk extends EntityPathBase<CashDesk> {

    private static final long serialVersionUID = -1458773858L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCashDesk cashDesk = new QCashDesk("cashDesk");

    public final QCashDeskAuth auth;

    public final NumberPath<java.math.BigDecimal> balance = createNumber("balance", java.math.BigDecimal.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCashDesk(String variable) {
        this(CashDesk.class, forVariable(variable), INITS);
    }

    public QCashDesk(Path<? extends CashDesk> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCashDesk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCashDesk(PathMetadata metadata, PathInits inits) {
        this(CashDesk.class, metadata, inits);
    }

    public QCashDesk(Class<? extends CashDesk> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.auth = inits.isInitialized("auth") ? new QCashDeskAuth(forProperty("auth")) : null;
    }

}

