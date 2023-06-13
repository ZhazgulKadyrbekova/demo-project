package crud.mvc.project.mapper.impl;

import crud.mvc.project.entity.Operation;
import crud.mvc.project.mapper.CashDeskMapperService;
import crud.mvc.project.mapper.OperationMapperService;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.dto.OperationDto;
import crud.mvc.project.model.dto.OperationUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class OperationMapperServiceImpl implements OperationMapperService {

    private final CashDeskMapperService cashDeskMapperService;

    public OperationMapperServiceImpl(CashDeskMapperService cashDeskMapperService) {
        this.cashDeskMapperService = cashDeskMapperService;
    }

    @Override
    public OperationCreateDto mapToCreateDto(Operation operation) {
        CashDeskDto from = cashDeskMapperService.mapToDto(operation.getFromCashDesk());
        CashDeskDto to = cashDeskMapperService.mapToDto(operation.getToCashDesk());

        return new OperationCreateDto(
                operation.getAmount(),
                operation.getCurrency(),
                from,
                to,
                to.name,
                operation.getSenderName(),
                operation.getReceiverName(),
                operation.getSenderPhoneNumber(),
                operation.getReceiverPhoneNumber(),
                operation.getDescription(),
                operation.getCode()
        );
    }

    @Override
    public OperationUpdateDto mapToUpdateDto(Operation operation) {
        return new OperationUpdateDto(
                operation.getId(),
                operation.getStatus()
        );
    }

    @Override
    public OperationDto mapToDto(Operation operation) {
        CashDeskDto from = cashDeskMapperService.mapToDto(operation.getFromCashDesk());
        CashDeskDto to = cashDeskMapperService.mapToDto(operation.getToCashDesk());

        return new OperationDto(
                operation.getAmount(),
                operation.getCurrency(),
                from,
                to,
                operation.getSenderName(),
                operation.getReceiverName(),
                operation.getSenderPhoneNumber(),
                operation.getReceiverPhoneNumber(),
                operation.getStatus(),
                operation.getDescription(),
                operation.getCreatedDate()
        );
    }
}
