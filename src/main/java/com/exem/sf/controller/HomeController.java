package com.exem.sf.controller;

import com.exem.sf.domain.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 24..
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String usersHome(Users user, Model model) {
        System.out.println(user.getFullname());
        return "index";
    }
}
