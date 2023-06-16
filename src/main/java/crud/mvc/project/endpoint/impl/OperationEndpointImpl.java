package crud.mvc.project.endpoint.impl;

import crud.mvc.project.config.PaginationProperties;
import crud.mvc.project.endpoint.OperationEndpoint;
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
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationEndpointImpl implements OperationEndpoint {
    private final OperationQueryService operationQueryService;
    private final OperationMapperService operationMapperService;
    private final PaginationProperties paginationProperties;

    public OperationEndpointImpl(OperationQueryService operationQueryService,
                                 OperationMapperService operationMapperService,
                                 PaginationProperties paginationProperties) {
        this.operationQueryService = operationQueryService;
        this.operationMapperService = operationMapperService;
        this.paginationProperties = paginationProperties;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OperationDto> getAll(OperationGetAllPayload operationGetAllPayload) {
        int page = operationGetAllPayload.getPage() - 1;
        PageRequest request = PageRequest.of(
                Math.max(page, 0),
                paginationProperties.getSize()
        );

        return operationQueryService
                .getAll(request)
                .map(operationMapperService::mapToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OperationDto> search(OperationSearchPayload operationSearchPayload) {
        int page = operationSearchPayload.getPage() - 1;
        PageRequest request = PageRequest.of(
                Math.max(page, 0),
                paginationProperties.getSize()
        );

        return operationQueryService
                .getAllBySearch(operationSearchPayload.search, request)
                .map(operationMapperService::mapToDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OperationDto> filter(OperationFilterPayload operationFilterPayload) {
        int page = operationFilterPayload.getPage() - 1;
        PageRequest request = PageRequest.of(
                Math.max(page, 0),
                paginationProperties.getSize()
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
