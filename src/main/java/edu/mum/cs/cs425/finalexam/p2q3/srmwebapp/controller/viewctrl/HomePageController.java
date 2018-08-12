package edu.mum.cs.cs425.finalexam.p2q3.srmwebapp.controller.viewctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/srm", "/srm/home"})
    public String displayHomePage() {
        return "public/home/index";
    }
}
