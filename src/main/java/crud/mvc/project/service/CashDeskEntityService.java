package crud.mvc.project.service;

import com.querydsl.core.BooleanBuilder;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.model.request.CashDeskCreateRequest;
import crud.mvc.project.model.request.CashDeskUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CashDeskEntityService {
    CashDesk create(CashDeskCreateRequest model);
    CashDesk findByQuery(BooleanBuilder booleanBuilder);
    CashDesk update(CashDesk cashDesk, CashDeskUpdateRequest model);
    List<CashDesk> findAll(BooleanBuilder booleanBuilder);
    Page<CashDesk> findAll(BooleanBuilder booleanBuilder, PageRequest request);
}