package uz.urspi.urspi;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.urspi.urspi.user.Role;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

@SpringBootApplication
@RequiredArgsConstructor
public class UrspiApplication {

    private  final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(UrspiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        if(!userService.checkUser("admin")){
            return args -> {
                User admin = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .role(Role.ADMIN)
                        .status(1)
                        .build();
                userService.createUser(admin);
            };
        }else {
            return args -> {};
        }

    };

}
