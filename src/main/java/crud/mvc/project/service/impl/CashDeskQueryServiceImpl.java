package crud.mvc.project.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.QCashDesk;
import crud.mvc.project.entity.QCashDeskAuth;
import crud.mvc.project.exception.NotFoundException;
import crud.mvc.project.service.CashDeskEntityService;
import crud.mvc.project.service.CashDeskQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CashDeskQueryServiceImpl implements CashDeskQueryService {

    private final CashDeskEntityService entityService;
    private final EntityManager entityManager;

    public CashDeskQueryServiceImpl(CashDeskEntityService entityService, EntityManager entityManager) {
        this.entityService = entityService;
        this.entityManager = entityManager;
    }

    @Override
    public CashDesk findById(long cashDeskId) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QCashDesk.cashDesk.id.eq(cashDeskId));
        return entityService.findByQuery(builder);
    }

    @Override
    public CashDesk getById(long cashDeskId) {
        CashDesk cashDesk = findById(cashDeskId);

        if (cashDesk == null) {
            throw new NotFoundException("CashDesk", "id", cashDeskId);
        }

        return cashDesk;
    }

    @Override
    public CashDesk getByUsername(String username) {
        QCashDeskAuth qCashDeskAuth = QCashDeskAuth.cashDeskAuth;
        QCashDesk qCashDesk = QCashDesk.cashDesk;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qCashDeskAuth.username.eq(username));

        return new JPAQuery<CashDesk> (entityManager)
                .from(qCashDesk)
                .select(qCashDesk)
                .innerJoin(qCashDeskAuth)
                .on(qCashDesk.auth.id.eq(qCashDeskAuth.id))
                .where(builder)
                .fetchOne();
    }

    @Override
    public List<CashDesk> getAll() {
        BooleanBuilder builder = new BooleanBuilder();

        return entityService.findAll(builder);
    }

    @Override
    public Page<CashDesk> getAll(PageRequest request) {
        BooleanBuilder builder = new BooleanBuilder();

        return entityService.findAll(builder, request);
    }
}
