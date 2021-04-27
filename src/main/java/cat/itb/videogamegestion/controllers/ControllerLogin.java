package cat.itb.videogamegestion.controllers;

import cat.itb.videogamegestion.models.UserObject;
import cat.itb.videogamegestion.repositories.UserRepository;
import cat.itb.videogamegestion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerLogin {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;



    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new UserObject());
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String afegirSubmit(@ModelAttribute("UserObject") UserObject userObject){
        userObject.setRol("USER");
        userService.putUser(userObject);
        return "redirect:/";

    }

}
