package uz.urspi.urspi.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers();

    User fetchUserByUsername(String username);

    void saveUser(User user);

    void createUser(User user);

    boolean checkUser(String username);

    User getCurrentUser();

    UserDetailsService userDetailsService();
}
