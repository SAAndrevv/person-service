package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user-info")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getUserInfo(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserDtoByUserName(principal.getName()));

        return "user";
    }

}
