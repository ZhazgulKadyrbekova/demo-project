package crud.mvc.project.controller;

import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.model.payload.CashDeskGetAllPayload;
import crud.mvc.project.util.PageNumberUtil;
import org.springframework.data.domain.Page;
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
    public String createForm() {
        return "cashDeskCreate";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CashDeskCreatePayload cashDeskCreatePayload) {
        cashDeskEndpoint.create(cashDeskCreatePayload);

        return "redirect:/cash-desk/get-all";
    }

    @RequestMapping("/get-all")
    public String getAllCashDesks(CashDeskGetAllPayload payload, Model model) {
        Page<CashDeskDto> dtos = cashDeskEndpoint.getAll(payload);
        List<Integer> pageNumbers = PageNumberUtil.getPageNumber(dtos);

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("cashDeskDtos", dtos);

        return "cashDesks";
    }

}
