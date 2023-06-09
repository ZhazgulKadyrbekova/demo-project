package crud.mvc.project.endpoint;

import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.mapper.CashDeskMapperService;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.model.payload.CashDeskGetAllPayload;
import crud.mvc.project.model.request.CashDeskAuthCreateRequest;
import crud.mvc.project.model.request.CashDeskCreateRequest;
import crud.mvc.project.service.CashDeskAuthEntityService;
import crud.mvc.project.service.CashDeskEntityService;
import crud.mvc.project.service.CashDeskQueryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public CashDeskDto create(CashDeskCreatePayload cashDeskCreatePayload) {
        String password = encoder.encode(cashDeskCreatePayload.password);
        CashDeskAuthCreateRequest authCreateRequest = new CashDeskAuthCreateRequest(
                cashDeskCreatePayload.name,
                password
        );
        authEntityService.create(authCreateRequest);

        CashDeskCreateRequest createRequest = new CashDeskCreateRequest(
                cashDeskCreatePayload.balance,
                cashDeskCreatePayload.name
        );
        CashDesk cashDesk = entityService.create(createRequest);

        return mapperService.mapToDto(cashDesk);
    }

    @Override
    public List<CashDeskDto> getAll() {
//        PageRequest request = PageRequest.of(
//                cashDeskGetAllPayload.page,
//                cashDeskGetAllPayload.size
//        );
        return queryService
                .getAll()
                .stream()
                .map(mapperService::mapToDto)
                .collect(Collectors.toList());
    }

}