package crud.mvc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class MyController {
//
//    private final OperationEndpoint operationEndpoint;
//
//    public MyController(OperationEndpoint operationEndpoint) {
//        this.operationEndpoint = operationEndpoint;
//    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index2")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String getResource(Model model, Principal principal) {
        String username = principal.getName();
        Map<String,String> map = new HashMap<>();
        map.put("date", LocalDate.now().toString());
        map.put("time", LocalTime.now().toString());
        map.put("name", "John Doe");
        map.put("message", "Hello Wold");
        map.put("username", username);

        model.addAllAttributes(map);
        return "index";
    }

    @GetMapping("/v2")
    public String getResource2(Model model) {
        Map<String,String> map = new HashMap<>();
        map.put("date", LocalDate.now().toString());
        map.put("time", LocalTime.now().toString());
        map.put("name", "John Doe");
        map.put("message", "Hello Wold");

        model.addAllAttributes(map);
        return "index2";
    }

//    @PostMapping
//    public String setResource(@ModelAttribute Model model) {
//        String username = userDetails.getUsername();
//
//        System.out.println();
//        System.out.println(userDetails);
//        System.out.println(username);
//        System.out.println();
//
//        return "aaaa";
//    }

}
