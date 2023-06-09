package crud.mvc.project.service;

import crud.mvc.project.entity.CashDesk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CashDeskQueryService {
    CashDesk getById(long cashDeskId);
    CashDesk findById(long cashDeskId);
    CashDesk getByUsername(String username);
    List<CashDesk> getAll();
    Page<CashDesk> getAll(PageRequest request);
}