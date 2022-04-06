package com.example.projectregistrpeple.controller;
import com.example.projectregistrpeple.domain.users.Users;
import com.example.projectregistrpeple.dto.ResponseUser;
import com.example.projectregistrpeple.dto.Status;
import com.example.projectregistrpeple.dto.StatusResponse;
import com.example.projectregistrpeple.service.userservice.UserServiceInterface;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Accessors
@Data
@Controller
public class UserController  {

    @Autowired
    UserServiceInterface userService;


    @Transactional
    @PostMapping("/registration") // API добавить пользователя
    public String registration(ResponseUser responseUser, Map<String, Object> model) {
        if (userService.findByUsers(responseUser.getLogin()).isEmpty()) {
            System.out.println("UserController.registration");
            System.out.println("проверили такого пользователя нет и надо добавлять");
            userService.AddUser(responseUser);
            return "modelstart";
        }
        model.put("message", "Такой пользователь уже есть ");
        return "main";
    }






}




