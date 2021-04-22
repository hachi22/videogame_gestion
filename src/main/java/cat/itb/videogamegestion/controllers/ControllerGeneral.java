package cat.itb.videogamegestion.controllers;

import cat.itb.videogamegestion.models.Videogame;
import cat.itb.videogamegestion.repositories.VideogameRepository;
import cat.itb.videogamegestion.services.UserService;
import cat.itb.videogamegestion.services.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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


    @GetMapping("/listUsers")
    public String listUsers(Model m){
        m.addAttribute("listUsers",userService.list());
        return "listUsers";
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
    public String update(@PathVariable("name") String videogame, Model m){

        name =videogame;
        m.addAttribute("Videogame",videogameService.searchByName(videogame));

        return "/updateVideogame";
    }

    @PostMapping("/updateVideogame")
    public String updateVideogame(@ModelAttribute("Videogame") Videogame videogame){
        videogameService.updateVideogame(videogame,name);
        return "redirect:/listVideogame";

    }

    @PostMapping("/addVideogame")
    public String addVideogame(@ModelAttribute("Videogame") Videogame videogame){
        videogameService.add(videogame);
        return "redirect:/listVideogame";

    }

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String removeAnimal(@PathVariable("name") String videogame){
        videogameService.removeVideogameByName(videogame);
        return "redirect:/listVideogame";
    }


}
