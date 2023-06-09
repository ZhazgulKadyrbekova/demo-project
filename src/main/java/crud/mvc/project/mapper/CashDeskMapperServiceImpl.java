package crud.mvc.project.mapper;

import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.model.dto.CashDeskDto;
import org.springframework.stereotype.Service;

@Service
public class CashDeskMapperServiceImpl implements CashDeskMapperService {

    @Override
    public CashDeskDto mapToDto(CashDesk cashDesk) {
        return new CashDeskDto(
                cashDesk.getId(),
                cashDesk.getBalance(),
                cashDesk.getName()
        );
    }
}
