package crud.mvc.project.service.impl;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.model.request.CashDeskCreateRequest;
import crud.mvc.project.model.request.CashDeskUpdateRequest;
import crud.mvc.project.repository.CashDeskRepository;
import crud.mvc.project.service.CashDeskEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashDeskEntityServiceImpl implements CashDeskEntityService {

    private final CashDeskRepository repository;

    public CashDeskEntityServiceImpl(CashDeskRepository repository) {
        this.repository = repository;
    }

    @Override
    public CashDesk create(CashDeskCreateRequest model) {
        CashDesk cashDesk = CashDesk.builder()
                .balance(model.balance)
                .name(model.name)
                .auth(model.auth)
                .build();

        return repository.save(cashDesk);
    }

    @Override
    public CashDesk findByQuery(BooleanBuilder booleanBuilder) {
        return repository.findOne(booleanBuilder).orElse(null);
    }

    @Override
    public CashDesk update(CashDesk cashDesk, CashDeskUpdateRequest model) {
        cashDesk.setBalance(model.balance);
        return repository.save(cashDesk);
    }

    @Override
    public List<CashDesk> findAll(BooleanBuilder booleanBuilder) {
        return (List<CashDesk>) repository.findAll(booleanBuilder);
    }

    @Override
    public Page<CashDesk> findAll(BooleanBuilder booleanBuilder, PageRequest request) {
        return repository.findAll(booleanBuilder, request);
    }
}
