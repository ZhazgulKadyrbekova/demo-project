package crud.mvc.project.controller;

import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.model.payload.CashDeskGetAllPayload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cash-desk")
public class CashDeskController {

    private final CashDeskEndpoint cashDeskEndpoint;

    public CashDeskController(CashDeskEndpoint cashDeskEndpoint) {
        this.cashDeskEndpoint = cashDeskEndpoint;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        return "cashDeskCreate";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CashDeskCreatePayload cashDeskCreatePayload, Model model) {
        CashDeskDto dto = cashDeskEndpoint.create(cashDeskCreatePayload);
        model.addAttribute(dto);

        return "index";
    }

    @RequestMapping("/get-all")
    public String getAllCashDesks(Model model) {

        List<CashDeskDto> dtos = cashDeskEndpoint.getAll();
        model.addAllAttributes(dtos);

        return "index";
    }

}
