package com.achords.utils.validators;

import com.achords.model.dto.user.UserDTO;
import com.achords.service.user.UserService;
import com.achords.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class UserValidation {

    private final UserService userService;

    public Map<String,String> getErrors(BindingResult bindingResult, UserDTO userDTO){
        Map<String, String> formalErrors = new HashMap<>(getFormErrors(bindingResult));
        if(formalErrors.isEmpty()){
            Map<String, String> authority = new HashMap<>(getAuthorityErrors(userDTO));
            formalErrors.putAll(authority);
        }
        return formalErrors;
    }

    public Map<String,String> getFormErrors(BindingResult bindingResult){
        Collector<FieldError,?,Map<String,String>> temp = Collectors.toMap(
                fieldError -> fieldError.getField() + fieldError.getCode() + "Error",
                FieldError::getDefaultMessage
        );

        return bindingResult.getFieldErrors().stream().collect(temp);
    }

    public Map<String,String> getAuthorityErrors(UserDTO userDTO){
        Map<String,String> temp = new HashMap<>();
        try{
            userService.findByEmail(userDTO.getEmail());
            temp.put("authorityEmailError","User with this email is already in system");
        }catch (UserNotFoundException ignored) {
        }
        try{
            userService.findByUsername(userDTO.getNickname());
            temp.put("authorityNicknameError","User with this nickname is already in system");
        }catch (UserNotFoundException ignored){
        }

        return temp;
    }

}
