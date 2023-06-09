package crud.mvc.project.controller;

import crud.mvc.project.endpoint.CashDeskEndpoint;
import crud.mvc.project.endpoint.OperationCreateEndpoint;
import crud.mvc.project.endpoint.OperationEndpoint;
import crud.mvc.project.endpoint.OperationProcessEndpoint;
import crud.mvc.project.entity.Currency;
import crud.mvc.project.entity.OperationStatus;
import crud.mvc.project.model.dto.CashDeskDto;
import crud.mvc.project.model.dto.OperationCreateDto;
import crud.mvc.project.model.dto.OperationDto;
import crud.mvc.project.model.dto.OperationUpdateDto;
import crud.mvc.project.model.payload.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return "create";
    }

    @RequestMapping(
            path = "create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String create(
            Principal principal,
            @Validated OperationCreatePayload createPayload,
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

        int totalPages = operationDtos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
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

        int totalPages = operationDtos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("operationDtos", operationDtos);
        model.addAttribute("cashDeskDtos", dtos);
        model.addAttribute("currencies", currencies);
        model.addAttribute("statuses", statuses);
        return "operations";
    }

    @GetMapping("/filter")
    public String filterOperations(OperationFilterPayload operationFilterPayload, Model model) {
//        System.out.println();
//        System.out.println(operationFilterPayload.fromCashDeskIds);
//        System.out.println(operationFilterPayload.toCashDeskIds);
//        System.out.println(operationFilterPayload.dateFrom);
//        System.out.println(operationFilterPayload.dateTo);
//        System.out.println(operationFilterPayload.status);
//        System.out.println(operationFilterPayload.currencies);
//        System.out.println(operationFilterPayload.amountFrom);
//        System.out.println(operationFilterPayload.amountTo);
//        System.out.println();
        Page<OperationDto> operationDtos = operationEndpoint.filter(operationFilterPayload);
        List<CashDeskDto> dtos = cashDeskEndpoint.getAll();
        List<Currency> currencies = List.of(Currency.values());
        List<OperationStatus> statuses = List.of(OperationStatus.values());

        int totalPages = operationDtos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("operationDtos", operationDtos);
        model.addAttribute("cashDeskDtos", dtos);
        model.addAttribute("currencies", currencies);
        model.addAttribute("statuses", statuses);
        return "operations";
    }

}
