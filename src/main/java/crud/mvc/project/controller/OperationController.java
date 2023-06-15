package crud.mvc.project.controller;

import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.endpoint.OperationCreateEndpoint;
import crud.mvc.project.endpoint.OperationEndpoint;
import crud.mvc.project.endpoint.OperationProcessEndpoint;
import crud.mvc.project.entity.enums.Currency;
import crud.mvc.project.entity.enums.OperationStatus;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.dto.OperationDto;
import crud.mvc.project.model.dto.OperationUpdateDto;
import crud.mvc.project.model.payload.*;
import crud.mvc.project.util.PageNumberUtil;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/operation")
public class OperationController {

    private final OperationEndpoint operationEndpoint;
    private final OperationCreateEndpoint operationCreateEndpoint;
    private final OperationProcessEndpoint operationProcessEndpoint;
    private final CashDeskEndpoint cashDeskEndpoint;

    public OperationController(OperationEndpoint operationEndpoint, OperationCreateEndpoint operationCreateEndpoint,
                               OperationProcessEndpoint operationProcessEndpoint, CashDeskEndpoint cashDeskEndpoint) {
        this.operationEndpoint = operationEndpoint;
        this.operationCreateEndpoint = operationCreateEndpoint;
        this.operationProcessEndpoint = operationProcessEndpoint;
        this.cashDeskEndpoint = cashDeskEndpoint;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("create")
    public String createForm(Model model) {
        List<CashDeskDto> dtos = cashDeskEndpoint.getAll();
        List<Currency> currencies = List.of(Currency.values());

        model.addAttribute("dtos", dtos);
        model.addAttribute("currencies", currencies);
        model.addAttribute("createPayload", new OperationCreatePayload());
        return "create";
    }

    @PostMapping("create")
    public String create(
            Principal principal,
            @Validated @ModelAttribute OperationCreatePayload createPayload,
            Model model) {
        String name = principal.getName();

        OperationCreateDto dto = operationCreateEndpoint.create(name, createPayload);
        model.addAttribute("operationCreateDto", dto);

        return "saved";
    }

    @GetMapping("process")
    public String processForm() {
        return "process";
    }

    @PostMapping(value = "process")
    public String process(Principal principal,
                          @Validated OperationProcessPayload processPayload,
                          Model model) {
        String name = principal.getName();

        OperationUpdateDto updateDto = operationProcessEndpoint.process(name, processPayload);

        model.addAttribute("updateDto", updateDto);
        return "processed";
    }

    @GetMapping
    public String getAllOperations(OperationGetAllPayload operationGetAllPayload, Model model) {
        Page<OperationDto> operationDtos = operationEndpoint.getAll(operationGetAllPayload);
        List<CashDeskDto> dtos = cashDeskEndpoint.getAll();
        List<Currency> currencies = List.of(Currency.values());
        List<OperationStatus> statuses = List.of(OperationStatus.values());
        List<Integer> pageNumbers = PageNumberUtil.getPageNumber(operationDtos);

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("operationDtos", operationDtos);
        model.addAttribute("cashDeskDtos", dtos);
        model.addAttribute("currencies", currencies);
        model.addAttribute("statuses", statuses);
        return "operations";
    }

    @GetMapping("/search")
    public String searchOperations(@Validated OperationSearchPayload operationSearchPayload, Model model) {
        Page<OperationDto> operationDtos = operationEndpoint.search(operationSearchPayload);
        List<CashDeskDto> dtos = cashDeskEndpoint.getAll();
        List<Currency> currencies = List.of(Currency.values());
        List<OperationStatus> statuses = List.of(OperationStatus.values());
        List<Integer> pageNumbers = PageNumberUtil.getPageNumber(operationDtos);

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("operationDtos", operationDtos);
        model.addAttribute("cashDeskDtos", dtos);
        model.addAttribute("currencies", currencies);
        model.addAttribute("statuses", statuses);
        return "operations";
    }

    @GetMapping("/filter")
    public String filterOperations(OperationFilterPayload operationFilterPayload, Model model) {
        Page<OperationDto> operationDtos = operationEndpoint.filter(operationFilterPayload);
        List<CashDeskDto> dtos = cashDeskEndpoint.getAll();
        List<Currency> currencies = List.of(Currency.values());
        List<OperationStatus> statuses = List.of(OperationStatus.values());
        List<Integer> pageNumbers = PageNumberUtil.getPageNumber(operationDtos);

        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("operationDtos", operationDtos);
        model.addAttribute("cashDeskDtos", dtos);
        model.addAttribute("currencies", currencies);
        model.addAttribute("statuses", statuses);
        return "operations";
    }

}
