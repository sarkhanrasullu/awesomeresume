package com.company.resumewebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/alma", method = {RequestMethod.GET, RequestMethod.POST})
    public String mainPage() throws Exception {

        return "/index";
    }


}
