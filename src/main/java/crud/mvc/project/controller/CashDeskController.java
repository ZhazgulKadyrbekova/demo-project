package crud.mvc.project.controller;

import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.payload.CashDeskCreatePayload;
import crud.mvc.project.model.payload.CashDeskGetAllPayload;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String create(@ModelAttribute @Validated CashDeskCreatePayload cashDeskCreatePayload, Model model) {
        cashDeskEndpoint.create(cashDeskCreatePayload);

        return "redirect:/cash-desk/get-all";
    }

    @RequestMapping("/get-all")
    public String getAllCashDesks(CashDeskGetAllPayload payload, Model model) {
        Page<CashDeskDto> dtos = cashDeskEndpoint.getAll(payload);

        int totalPages = dtos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("cashDeskDtos", dtos);

        return "cashDesks";
    }

}
