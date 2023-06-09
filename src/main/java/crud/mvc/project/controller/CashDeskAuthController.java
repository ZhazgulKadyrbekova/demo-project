package crud.mvc.project.controller;

import crud.mvc.project.model.payload.CashDeskAuthLoginPayload;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class CashDeskAuthController {

    private final AuthenticationManager authenticationManager;

    public CashDeskAuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

//    @PostMapping
//    public String login(CashDeskAuthLoginPayload cashDeskAuthLoginPayload) {
//
//        System.out.println();
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        System.out.println();
//        Authentication authentication = new UsernamePasswordAuthenticationToken(
//                cashDeskAuthLoginPayload.username,
//                cashDeskAuthLoginPayload.password
//        );
//        Authentication authenticated = authenticationManager.authenticate(authentication);
//
//        if (authenticated.isAuthenticated()) {
//            // Redirect to the desired page after successful login
//            return "redirect:/index";
//        } else {
//            // Handle failed login attempt
//            return "redirect:/login?error";
//        }
//    }

}
