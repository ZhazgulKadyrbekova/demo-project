package crud.mvc.project.endpoint;

import crud.mvc.project.exception.OperationFilterException;
import crud.mvc.project.mapper.OperationMapperService;
import crud.mvc.project.model.dto.OperationDto;
import crud.mvc.project.model.payload.OperationFilterPayload;
import crud.mvc.project.model.payload.OperationGetAllPayload;
import crud.mvc.project.model.payload.OperationSearchPayload;
import crud.mvc.project.service.OperationQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OperationEndpointImpl implements OperationEndpoint {
    private final OperationQueryService operationQueryService;
    private final OperationMapperService operationMapperService;

    public OperationEndpointImpl(OperationQueryService operationQueryService, OperationMapperService operationMapperService) {
        this.operationQueryService = operationQueryService;
        this.operationMapperService = operationMapperService;
    }

    @Override
    public Page<OperationDto> getAll(OperationGetAllPayload operationGetAllPayload) {

        PageRequest request = PageRequest.of(
                operationGetAllPayload.page,
                operationGetAllPayload.size
        );

        return operationQueryService
                .getAll(request)
                .map(operationMapperService::mapToDto);
    }

    @Override
    public Page<OperationDto> search(OperationSearchPayload operationSearchPayload) {

        PageRequest request = PageRequest.of(
                operationSearchPayload.page,
                operationSearchPayload.size
        );

        return operationQueryService
                .getAllBySearch(operationSearchPayload.search, request)
                .map(operationMapperService::mapToDto);
    }

    @Override
    public Page<OperationDto> filter(OperationFilterPayload operationFilterPayload) {

        PageRequest request = PageRequest.of(
                operationFilterPayload.page,
                operationFilterPayload.size
        );

        if (operationFilterPayload.dateFrom != null && operationFilterPayload.dateTo != null
                && operationFilterPayload.dateFrom.isAfter(operationFilterPayload.dateTo)) {
            throw new OperationFilterException("dateFrom", "dateTo", operationFilterPayload.dateFrom, operationFilterPayload.dateTo);
        }

        if (operationFilterPayload.amountFrom != null && operationFilterPayload.amountTo != null
                && operationFilterPayload.amountFrom.compareTo(operationFilterPayload.amountTo) == 1) {
            throw new OperationFilterException("amountFrom", "amountTo", operationFilterPayload.amountFrom, operationFilterPayload.amountTo);
        }

        return operationQueryService
                .getAllByFilter(operationFilterPayload, request)
                .map(operationMapperService::mapToDto);
    }
}
