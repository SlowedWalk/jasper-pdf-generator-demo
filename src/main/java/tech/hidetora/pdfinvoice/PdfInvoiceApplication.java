package tech.hidetora.pdfinvoice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tech.hidetora.pdfinvoice.entity.User;
import tech.hidetora.pdfinvoice.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class PdfInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfInvoiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            var users = List.of("hidetora", "arthemis", "aomine", "tetsuya", "aoi");

            List<User> usersList = users.stream().map(s -> new User(s, s+" lastname", s, "61354532135", s+"@gmail.com")).toList();
            userRepository.saveAll(usersList);
        };
    }
}
