package crud.mvc.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CommonController {

    @RequestMapping("/index")
    public String login() {
        return "index";
    }

}
