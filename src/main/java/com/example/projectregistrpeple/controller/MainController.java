package com.example.projectregistrpeple.controller;
import com.example.projectregistrpeple.domain.users.Users;
import com.example.projectregistrpeple.dto.ResponseNote;
import com.example.projectregistrpeple.dto.ResponseUser;
import com.example.projectregistrpeple.dto.Status;
import com.example.projectregistrpeple.dto.StatusResponse;
import com.example.projectregistrpeple.service.userservice.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Accessors
@Data
@Controller
@RequiredArgsConstructor
public class MainController {

    @Autowired
    UserServiceInterface userService;

    @GetMapping("/") // Главное меню
    public String mainmenu (Principal principal,Map <String ,Object> model) {

        Optional<Users> use  = userService.findByUsers(principal.getName());

        if(use.isEmpty()) return ""; // если пользователя не нашли , надо подумать над логикой .

        String usertype = use.get().getType();

        model.put("usertype",usertype);


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
    public String authorization() {

        return "authorization";}

    @Transactional
    @PostMapping("/authorization")
    public String getLogin() {
        return "authorization";}








    @GetMapping("/testMenu") // Главное меню
    public String mainPage (Map<String ,Object> model) {
        String string = "seller";
        model.put("model",string);
        return "mainmenu";}

    @PostMapping("/adNotes")
    public String addNote(ResponseNote responseNote,Map<String ,Object> model){
        String string = responseNote.getFlag();
        model.put("model",string);
        System.out.println("ControllerForTesting.addNote");
        return "mainmenu";
    }





}












