package lv.javaguru.java2.domain;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="UserId")
    private long id;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="UserName", nullable = false)
    private String username;
    @Column(name="Email", nullable = false)
    private String email;
    @Column(name="Coins")
    private float coins;
    @Column(name="PassW", nullable = false)
    private String password;

    @Column(name="Visible")
    private boolean isVisible;
    public User() {

    }

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.username = user.username;
        this.email = user.email;
        this.password = user.password;
    }

    public long getUserId() {
        return id;
    }

    public void setUserId(long userId) {
        this.id = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() { return username; }

    public void setUsername(String userName) { this.username = userName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public float getCoins() { return coins; }

    public void setCoins(float coins) { this.coins = coins; }

    public void setPassword(String password) { this.password = password;}

    public String getPassword() {return this.password;}

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
