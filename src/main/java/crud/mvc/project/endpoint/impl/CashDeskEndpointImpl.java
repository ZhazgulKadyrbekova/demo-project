package crud.mvc.project.endpoint.impl;

import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.entity.CashDeskAuth;
import crud.mvc.project.entity.enums.CashDeskRole;
import crud.mvc.project.mapper.CashDeskMapperService;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.model.payload.CashDeskGetAllPayload;
import crud.mvc.project.model.request.CashDeskAuthCreateRequest;
import crud.mvc.project.model.request.CashDeskCreateRequest;
import crud.mvc.project.service.CashDeskAuthEntityService;
import crud.mvc.project.service.CashDeskEntityService;
import crud.mvc.project.service.CashDeskQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CashDeskEndpointImpl implements CashDeskEndpoint {

    private final CashDeskQueryService queryService;
    private final CashDeskEntityService entityService;
    private final CashDeskAuthEntityService authEntityService;
    private final CashDeskMapperService mapperService;
    private final PasswordEncoder encoder;

    public CashDeskEndpointImpl(CashDeskQueryService queryService, CashDeskEntityService entityService,
                                CashDeskAuthEntityService authEntityService, CashDeskMapperService mapperService,
                                PasswordEncoder encoder) {
        this.queryService = queryService;
        this.entityService = entityService;
        this.authEntityService = authEntityService;
        this.mapperService = mapperService;
        this.encoder = encoder;
    }

    @Override
    public CashDeskDto createAdmin(CashDeskCreatePayload cashDeskCreatePayload) {
        CashDeskRole role = CashDeskRole.ADMIN;
        CashDesk cashDesk = create(cashDeskCreatePayload, role);

        return mapperService.mapToDto(cashDesk);
    }

    @Override
    @Transactional
    public CashDeskDto create(CashDeskCreatePayload cashDeskCreatePayload) {
        CashDeskRole role = CashDeskRole.CASH_DESK;
        CashDesk cashDesk = create(cashDeskCreatePayload, role);

        return mapperService.mapToDto(cashDesk);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CashDeskDto> getAll() {
        return queryService
                .getAll()
                .stream()
                .map(mapperService::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CashDeskDto> getAll(CashDeskGetAllPayload payload) {
        PageRequest request = PageRequest.of(
                payload.page,
                payload.size
        );
        return queryService
                .getAll(request)
                .map(mapperService::mapToDto);
    }

    private CashDesk create(CashDeskCreatePayload cashDeskCreatePayload, CashDeskRole role) {
        String password = encoder.encode(cashDeskCreatePayload.password);
        CashDeskAuthCreateRequest authCreateRequest = new CashDeskAuthCreateRequest(
                cashDeskCreatePayload.username,
                password,
                role
        );
        CashDeskAuth auth = authEntityService.create(authCreateRequest);

        CashDeskCreateRequest createRequest = new CashDeskCreateRequest(
                cashDeskCreatePayload.balance,
                cashDeskCreatePayload.name,
                auth
        );
        return entityService.create(createRequest);
    }
}
