package cn.booksp.sharebook.controller;

import cn.booksp.sharebook.domain.User;
import cn.booksp.sharebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        if(userService.verify(user)){
            session.setAttribute("user", user.getUsername());
        }
        return "redirect:/article/release";
    }
}
