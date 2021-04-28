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

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.save(new UserObject("user1", passwordEncoder("1234"), "1234"));
        userRepository.save(new UserObject("ADMIN", passwordEncoder("ADMIN"), "ADMIN","ADMIN"));
    }

    public UserObject putUser(UserObject user){
        user.setRol("USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user;}


    public UserObject checkUsername(String username){
        return userRepository.findById(username).orElse(null);
    }

    public String passwordEncoder(String pass) {
        return new BCryptPasswordEncoder().encode(pass);
    }
}

