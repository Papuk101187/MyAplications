package com.example.projectregistrpeple.controller;
import com.example.projectregistrpeple.dto.ResponseUser;
import com.example.projectregistrpeple.dto.Status;
import com.example.projectregistrpeple.dto.StatusResponse;
import com.example.projectregistrpeple.service.userservice.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.transaction.Transactional;
import java.util.Map;


@Accessors
@Data
@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    UserServiceInterface userService;

    @GetMapping("/") // Главное меню
    public String mainmenu (ResponseUser responseUser) {
        return "mainmenu";}

    @GetMapping("/entry") // авторизация вход в приложение
    public String entry(ResponseUser responseUser) {
        return "entry";}

    @GetMapping("/registration")
    public String registration(Map<String, Object> model ) {
        model.put("message", " ");
        return "registration";}


    @Transactional
    @PostMapping("/registration")
    public String registration(ResponseUser responseUser, Map<String, Object> model) {

        System.out.println("responseUser.getLogin "+responseUser.getLogin());
        System.out.println("responseUser.getType "+responseUser.getType());
        System.out.println("responseUser.getPassword "+responseUser.getPassword());

        System.out.println("PFFF");
        if (userService.findByUsers(responseUser.getLogin()).isEmpty()) {
            userService.AddUser(responseUser);
            return "entry";}
        model.put("message", "Такой пользователь уже есть ");
        return "entry";}


    @GetMapping("/authorization")
    public String authorization(ResponseUser responseUser) {
        return "authorization";}

    @RequestMapping("/authorization")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout,
     Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "authorization";
    }













}












