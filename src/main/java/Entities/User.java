package Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {
@Id
@SequenceGenerator(name="userid_sequence",
            sequenceName = "userid_sequence",
            allocationSize = 1)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator="userid_sequence"
)
    private long id;
    private String login;
    private String email;

    public User(long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
