package cat.itb.videogamegestion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

@Entity
public class UserObject {

    @Id
    private String username;

    private String password;

    private String samePassword;

    private String rol;

    public UserObject(String name, String password, String samePassword) {
        this.username = name;
        this.password = password;
        this.samePassword = samePassword;
        this.rol = "USER";
    }


    public void setRol(String rol) {
        this.rol = rol;
    }
}
