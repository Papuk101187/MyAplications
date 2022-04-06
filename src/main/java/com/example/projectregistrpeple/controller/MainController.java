package com.example.projectregistrpeple.controller;
import lombok.RequiredArgsConstructor;
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


    @GetMapping("")
    public String startMenu() {
        return "modelstart";
    }


    @GetMapping("/main")
    public String registraction(Map<String, Object> model ) {
        model.put("message", " ");
        return "main";
    }



    @Transactional
    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "testing";
    }
















}
