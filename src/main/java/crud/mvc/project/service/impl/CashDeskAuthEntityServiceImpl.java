package crud.mvc.project.service.impl;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.CashDeskAuth;
import crud.mvc.project.entity.QCashDeskAuth;
import crud.mvc.project.model.request.CashDeskAuthCreateRequest;
import crud.mvc.project.repository.CashDeskAuthRepository;
import crud.mvc.project.service.CashDeskAuthEntityService;
import org.springframework.stereotype.Service;

@Service
public class CashDeskAuthEntityServiceImpl implements CashDeskAuthEntityService {

    private final CashDeskAuthRepository repository;

    public CashDeskAuthEntityServiceImpl(CashDeskAuthRepository repository) {
        this.repository = repository;
    }

    @Override
    public CashDeskAuth create(CashDeskAuthCreateRequest createRequest) {
        CashDeskAuth auth = new CashDeskAuth();
        auth.setUsername(createRequest.username);
        auth.setPassword(createRequest.password);
        return repository.save(auth);
    }

    @Override
    public CashDeskAuth findById(long id) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QCashDeskAuth.cashDeskAuth.id.eq(id));
        return repository.findOne(builder).orElse(null);
    }

    @Override
    public CashDeskAuth findByUsername(String username) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(QCashDeskAuth.cashDeskAuth.username.eq(username));
        return repository.findOne(builder).orElse(null);
    }
}
