package com.exem.sf.controller;

import com.exem.sf.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dev on 2017. 3. 20..
 */
@Controller
@RequestMapping("/")
public class HomeController {
    final MemberRepository memberRepository;

    @Autowired
    public HomeController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
}
