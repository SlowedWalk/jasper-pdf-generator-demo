package tech.hidetora.pdfinvoice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tech.hidetora.pdfinvoice.entity.User;
import tech.hidetora.pdfinvoice.repository.UserRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableJpaAuditing
public class PdfInvoiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfInvoiceApplication.class, args);
    }




    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            User user1 = User.builder()
                    .firstname("John")
                    .lastname("Doe")
                    .matricule("19I-123456")
                    .phone("123456789")
                    .email("jone.doe@gmail.com")
                    .build();
            User user2 = User.builder()
                    .firstname("Jane")
                    .lastname("Doe")
                    .matricule("20G-123456")
                    .phone("123456789")
                    .email("jane.doe@gmail.com")
                    .build();
            User user3 = User.builder()
                    .firstname("Jack")
                    .lastname("Doe")
                    .matricule("14S-123456")
                    .phone("123456789")
                    .email("jack.doe@gmail.com")
                    .build();
            User user4 = User.builder()
                    .firstname("Jill")
                    .lastname("Doe")
                    .matricule("07I-123456")
                    .phone("123456789")
                    .email("jill.doe@gmail.com")
                    .build();
            User user5 = User.builder()
                    .firstname("James")
                    .lastname("Doe")
                    .matricule("04B-123456")
                    .phone("123456789")
                    .email("james.doe@gmail.com")
                    .build();
            userRepository.saveAll(List.of(user1, user2, user3, user4, user5));
        };
    }
}
