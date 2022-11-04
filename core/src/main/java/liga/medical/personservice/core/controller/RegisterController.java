package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.api.service.UserService;
import liga.medical.personservice.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
@Api("Registration API")
public class RegisterController {

    private final UserService userService;

    private final UserValidate userValidate;

    @PostMapping
    @ApiOperation("Register current user")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidate.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        return "redirect:/user-info";
    }

    @GetMapping
    @ApiOperation("Open registration page")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

}
