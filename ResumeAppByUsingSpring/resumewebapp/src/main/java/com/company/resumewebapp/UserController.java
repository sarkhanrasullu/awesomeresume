package com.company.resumewebapp;

import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        List<User> list = userService.getAll(null,null,null);
        request.setAttribute("users", list);
        return "usersJ";
    }
}
