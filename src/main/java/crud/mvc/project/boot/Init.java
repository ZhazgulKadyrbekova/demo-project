package crud.mvc.project.boot;


import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.entity.CashDesk;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.service.CashDeskQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Init implements CommandLineRunner {

    private final CashDeskEndpoint endpoint;
    private final CashDeskQueryService queryService;

    public Init(CashDeskEndpoint endpoint, CashDeskQueryService queryService) {
        this.endpoint = endpoint;
        this.queryService = queryService;
    }

    @Override
    public void run(String... args) {
        CashDesk cashDesk = queryService.findById(1L);
        if (cashDesk != null) {
            return;
        }

        CashDeskCreatePayload createPayload = new CashDeskCreatePayload(
                "Касса №1",
                "cash_desk_1",
                new BigDecimal(20_000),
                "password_cash_desk_1"
        );
        endpoint.createAdmin(createPayload);
    }
}