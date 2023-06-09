package crud.mvc.project.service;

import crud.mvc.project.entity.CashDeskAuth;
import crud.mvc.project.model.request.CashDeskAuthCreateRequest;

public interface CashDeskAuthEntityService {
    CashDeskAuth create(CashDeskAuthCreateRequest createRequest);
    CashDeskAuth findById(long id);
    CashDeskAuth findByUsername(String username);
}