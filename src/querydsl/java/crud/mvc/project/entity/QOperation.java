package crud.mvc.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOperation is a Querydsl query type for Operation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOperation extends EntityPathBase<Operation> {

    private static final long serialVersionUID = -1341221003L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOperation operation = new QOperation("operation");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final EnumPath<Currency> currency = createEnum("currency", Currency.class);

    public final StringPath description = createString("description");

    public final QCashDesk fromCashDesk;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath receiverName = createString("receiverName");

    public final StringPath receiverPhoneNumber = createString("receiverPhoneNumber");

    public final StringPath senderName = createString("senderName");

    public final StringPath senderPhoneNumber = createString("senderPhoneNumber");

    public final NumberPath<java.math.BigDecimal> somAmount = createNumber("somAmount", java.math.BigDecimal.class);

    public final EnumPath<OperationStatus> status = createEnum("status", OperationStatus.class);

    public final QCashDesk toCashDesk;

    public QOperation(String variable) {
        this(Operation.class, forVariable(variable), INITS);
    }

    public QOperation(Path<? extends Operation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOperation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOperation(PathMetadata metadata, PathInits inits) {
        this(Operation.class, metadata, inits);
    }

    public QOperation(Class<? extends Operation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fromCashDesk = inits.isInitialized("fromCashDesk") ? new QCashDesk(forProperty("fromCashDesk"), inits.get("fromCashDesk")) : null;
        this.toCashDesk = inits.isInitialized("toCashDesk") ? new QCashDesk(forProperty("toCashDesk"), inits.get("toCashDesk")) : null;
    }

}

