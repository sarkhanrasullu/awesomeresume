package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.DummyService;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        String nationalityIdStr = request.getParameter("nid");
//        Integer nationalityId=null;
//        if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()) {
//            nationalityId = Integer.parseInt(nationalityIdStr);
//        }
//
//
//        List<UserDTO> list = userService.getAll(name, surname, nationalityId);
//
//        request.setAttribute("list", list);
//        return "users";
//    }Data Transfer Object
    @RequestMapping(method = RequestMethod.GET, value="/users")//users?name=Sarkhan
    public ModelAndView index(
            @RequestParam(value="name", required = false) String name,
            @RequestParam(value="surname", required = false) String surname,
            @RequestParam(value="nid", required = false) Integer nationalityId){
        List<User> list = userService.getAll(name, surname, nationalityId);
        ModelAndView mv = new ModelAndView("users");

        mv.addObject("users",list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value="/usersm")//users?name=Sarkhan
        public ModelAndView indexM(
                @Valid
                @ModelAttribute("user") UserForm u,
                BindingResult bindingResult){
        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            return mv;
        }

        List<User> list = userService.getAll(u.getName(), u.getSurname(), u.getNationalityId());
        mv.addObject("users", list);
        return mv;
    }


//    @RequestMapping(method = RequestMethod.GET, value="/alma")//users?name=Sarkhan
//    public String login(){
//        return "login";
//    }

    @RequestMapping(method = {RequestMethod.GET}, value="/login")//users?name=Sarkhan
    public String loginPost(){
        return "login";
    }

    @RequestMapping(method = {RequestMethod.GET}, value="/logout")//users?name=Sarkhan
    public String logoutPage(){
        return "logout";
    }

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = {RequestMethod.GET}, value="/foo")//users?name=Sarkhan
    public String foo(){
        System.out.println("foo in Controller");
        dummyService.foo();
        return "users";
    }

    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
       return new UserForm(null, null,null);
    }
}
