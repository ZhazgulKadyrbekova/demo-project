package crud.mvc.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCashDeskAuth is a Querydsl query type for CashDeskAuth
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCashDeskAuth extends EntityPathBase<CashDeskAuth> {

    private static final long serialVersionUID = -1603357850L;

    public static final QCashDeskAuth cashDeskAuth = new QCashDeskAuth("cashDeskAuth");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QCashDeskAuth(String variable) {
        super(CashDeskAuth.class, forVariable(variable));
    }

    public QCashDeskAuth(Path<? extends CashDeskAuth> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCashDeskAuth(PathMetadata metadata) {
        super(CashDeskAuth.class, metadata);
    }

}

