package cat.itb.videogamegestion.services;

import cat.itb.videogamegestion.models.Videogame;
import cat.itb.videogamegestion.repositories.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VideogameService {

    public void add( Videogame videogame) {
        videogameRepository.save(videogame);
    }

    @Autowired
    private VideogameRepository videogameRepository;

    @PostConstruct
    public void init() {
        videogameRepository.save(new Videogame("Minecraft", "A constructing game"));
        videogameRepository.save(new Videogame("Final Fantasy XIV", "An MMORPG game in wich you have to fight versus the Garlean Empire"));
    }

    public Videogame searchByName(String name){
        return videogameRepository.findById(name).orElse(null);
    }

    public void removeVideogameByName(String name){
        videogameRepository.deleteById(name);
    }

}
