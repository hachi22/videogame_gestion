package cat.itb.videogamegestion.services;

import cat.itb.videogamegestion.models.UserObject;
import cat.itb.videogamegestion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<UserObject> rep = new ArrayList<>();
    /*
    public void putUser(UserObject userObject) {
        userObject.setPassword(passwordEncoder(userObject.getPassword()));
        rep.add(userObject);
    }

     */
    public List<UserObject> list() {
        return rep;
    }



    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        //  rep.addAll(
        //      Arrays.asList(
        //              new UserObject("user1", passwordEncoder("user1"), "user1"),
        //            new UserObject("ADMIN", passwordEncoder("ADMIN"), "ADMIN","ADMIN")
        //  ));
        userRepository.save(new UserObject("user1", "1234", "1234"));
        userRepository.save(new UserObject("ADMIN", "ADMIN", "ADMIN","ADMIN"));
    }

    
    /*public UserObject checkUsername(String userName) {
        UserObject userObject = null;
        boolean found = false;
        for (int i = 0; i < rep.size() && !found; i++) {
            if (userName.equals(rep.get(i).getUsername())){

                userObject = rep.get(i);
                found=true;
            }
        }
        return  userObject;
    }
*/
    public UserObject checkUsername(String username){
        return userRepository.findById(username).orElse(null);
    }

    public String passwordEncoder(String pass) {
        return new BCryptPasswordEncoder().encode(pass);
    }
}

