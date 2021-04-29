package cat.itb.videogamegestion.controllers;

import cat.itb.videogamegestion.models.UserObject;
import cat.itb.videogamegestion.models.Videogame;
import cat.itb.videogamegestion.repositories.UserRepository;
import cat.itb.videogamegestion.repositories.VideogameRepository;
import cat.itb.videogamegestion.services.UserService;
import cat.itb.videogamegestion.services.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Controller
public class ControllerGeneral {

    String name;

    @Autowired
    VideogameService videogameService;
    @Autowired
    UserService userService;
    @Autowired
    VideogameRepository videogameRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("/listUsers")
    public List<UserObject> listUsers(){
        return (List<UserObject>) userRepository.findAll();
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/listVideogame")
    public List<Videogame> listVideogame(){
        return (List<Videogame>) videogameRepository.findAll();
    }

    @RequestMapping("/add")
    public String addVideogame(Model model) {
        model.addAttribute("Videogame", new Videogame());
        return "addVideogame";
    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String update(@PathVariable("name") String videogame, Model m) {

        name =videogame;
        m.addAttribute("Videogame",videogameService.searchByName(videogame));

        return "updateVideogame";
    }

    @PostMapping("/addVideogame")
    public String addVideogame(@ModelAttribute("Videogame") Videogame videogame){
        videogameService.add(videogame);
        return "redirect:/listVideogame";

    }

    @RequestMapping("/updateVideogame")
    public String updateVideogame(@ModelAttribute("Videogame") String name, Videogame videogame){

        if (videogame != null && videogameRepository.existsById(name)){

            videogameRepository.findById(name).get();

            videogame.setName(videogame.getName());
            videogame.setDescription(videogame.getDescription());

             videogameRepository.save(videogame);
        }
        return "redirect:/listVideogame";
    }

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeVideogame(@PathVariable("name") String videogame){
        videogameService.removeVideogameByName(videogame);
        return "redirect:/listVideogame";
    }


}
