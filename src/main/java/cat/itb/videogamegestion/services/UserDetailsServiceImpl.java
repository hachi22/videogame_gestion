package cat.itb.videogamegestion.services;

import cat.itb.videogamegestion.models.UserObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserObject userObject = userService.checkUsername(username);

        User.UserBuilder builder;

        if(userObject!=null){
            builder=User.withUsername(username);
            builder.disabled(false);
            builder.password(userObject.getPassword());
            builder.roles(userObject.getRol());
        }
        else throw new UsernameNotFoundException("User dont found");
        return builder.build();
    }
}
