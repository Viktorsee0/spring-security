package by.tms.tmsspringsecurity.controller;

import by.tms.tmsspringsecurity.model.User;
import by.tms.tmsspringsecurity.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AuthController(@Qualifier("userDetailsServiceImpl") UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login");
    }

    @GetMapping("/success")
    public ModelAndView getSuccessPage(){
        return new ModelAndView("success");
    }

    @GetMapping("/reg")
    public ModelAndView getRegPage(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("reg");
    }

    @PostMapping("/reg")
    public ModelAndView postRegPage(User user){
        userDetailsService.registration(user);
        return new ModelAndView("reg");
    }
}
