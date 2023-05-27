package com.macnonline.MySecurityProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MyController {
    @GetMapping("/")
    public String pageAllUserAndQuest(){
       return"This page from all users and quest";
    }
    @GetMapping("/user")
    public String pageForAllUser(Principal principal){
        return "Page from authorised users "+principal.getName();
    }
    @GetMapping("/admin")
    public String pageForAdmin(){
        return "Only Admin";
    }
}
