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

    private List<Videogame> repositori = new ArrayList<>();

    public void add( Videogame videogame) {
        repositori.add(videogame);
    }
    public List<Videogame> list() {
        return repositori;
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


/*
    public Videogame searchByName(String videogameTitle) {
        Videogame videogame = null;
        boolean found = false;
        for (int i = 0; i < repositori.size() && !found; i++) {
            if (videogameTitle.equals(repositori.get(i).getName())){

                videogame = repositori.get(i);
                found=true;
            }
        }
        return  videogame;
    }

    public void removeVideogameByName(String videogameName){
        Videogame videogame = null;
        boolean found = false;
        for (int i = 0; i < repositori.size() && !found; i++) {
            if (videogameName.equals(repositori.get(i).getName())){

                videogame = repositori.get(i);
                found=true;
            }
        }
        repositori.remove(videogame);
    }
*/
    public void updateVideogame(Videogame videogame, String textChange ){
        boolean found = false;
        for (int i = 0; i < repositori.size() && !found; i++) {
            if (textChange.equals(repositori.get(i).getName())){


                repositori.get(i).setName(videogame.getName());
                repositori.get(i).setDescription(videogame.getDescription());

            }
        }

    }
}
