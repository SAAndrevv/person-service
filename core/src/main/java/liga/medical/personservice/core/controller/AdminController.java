package liga.medical.personservice.core.controller;

import liga.medical.personservice.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.getAllUsersDto());

        return "admin";
    }

    @PostMapping("/delete-user")
    public String deleteUser(Model model, @RequestParam("userId") String userId) {
        userService.deleteById(userId);

        return "redirect:/admin";
    }

    @PostMapping("/add-role")
    public String addRoleToUser(Model model, @RequestParam(name = "id") String userId,
                                @RequestParam(name = "role") String role) {
        userService.addRoleToUser(userId, role);

        return "redirect:/admin";
    }

}
