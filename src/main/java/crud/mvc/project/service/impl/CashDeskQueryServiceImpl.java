package crud.mvc.project.service.impl;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.QCashDesk;
import crud.mvc.project.exception.NotFoundException;
import crud.mvc.project.service.CashDeskEntityService;
import crud.mvc.project.service.CashDeskQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashDeskQueryServiceImpl implements CashDeskQueryService {

    private final CashDeskEntityService entityService;

    public CashDeskQueryServiceImpl(CashDeskEntityService entityService) {
        this.entityService = entityService;
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
    public CashDesk getByName(String name) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QCashDesk.cashDesk.name.eq(name));
        return entityService.findByQuery(builder);
    }

    @Override
    public List<CashDesk> getAll() {
        BooleanBuilder builder = new BooleanBuilder();

        return entityService.findAll(builder);
    }
}
