package crud.mvc.project.endpoint;

import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.model.payload.CashDeskGetAllPayload;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CashDeskEndpoint {
    CashDeskDto create(CashDeskCreatePayload cashDeskCreatePayload);
    List<CashDeskDto> getAll();
}
