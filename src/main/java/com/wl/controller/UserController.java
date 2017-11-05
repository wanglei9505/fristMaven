package com.wl.controller;

import com.wl.po.User;
import com.wl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by WL on 2017/7/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public String getUser(@RequestParam(value = "id") String id, Model model){
        User user=userService.getUser(id);
        model.addAttribute("user",user);
        return "index";
    }
}
