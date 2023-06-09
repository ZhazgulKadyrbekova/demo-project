package crud.mvc.project.mapper;

import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.model.dto.CashDeskDto;

public interface CashDeskMapperService {
    CashDeskDto mapToDto(CashDesk cashDesk);
}
