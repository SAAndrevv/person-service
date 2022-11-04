package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("User information API")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation("Get current user information")
    public String getUserInfo(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserDtoByUserName(principal.getName()));

        return "user";
    }

}
