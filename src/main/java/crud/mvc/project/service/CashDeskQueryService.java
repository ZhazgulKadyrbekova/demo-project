package crud.mvc.project.service;

import crud.mvc.project.entity.CashDesk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CashDeskQueryService {
    CashDesk getById(long cashDeskId);
    CashDesk findById(long cashDeskId);
    CashDesk getByName(String name);
    List<CashDesk> getAll();
}