package com.achords.controller.visible;

import com.achords.model.dto.user.UserDTO;
import com.achords.service.user.UserService;
import com.achords.utils.converters.UserConverter;
import com.achords.utils.exceptions.RoleNotFoundException;
import com.achords.utils.validators.UserValidation;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final UserValidation userValidation;


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationGet(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult bindingResult, Model model) throws RoleNotFoundException {
        Map<String, String> errors = userValidation.getErrors(bindingResult, userDTO);
        System.out.println(errors.toString());
        if (!errors.isEmpty()) {
            model.mergeAttributes(errors);
            return "registration";
        } else {
            userService.save(userDTO);
            return "redirect:/login";
        }
    }

}
