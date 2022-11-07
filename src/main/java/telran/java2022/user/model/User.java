package telran.java2022.user.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(of = {"login"})
@Getter
@Document(collection = "users")

public class User {
    @Setter
    String login;
    @Setter
    String firstName;
    @Setter
    String lastName;
    @Setter
    Set<String> roles;
    @Setter
    String password;

    public User(String login, String firstName, String lastName, String password) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        roles = new HashSet<>();
    }
    public void update(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void addRole(String role){
        roles.add(role);
    }
    public void removeRole(String role){
        roles.remove(role);
    }

}
