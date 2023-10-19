package tech.hidetora.pdfinvoice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    @Column(unique = true, nullable = false)
    private String matricule;
    private String lastname;
    private String phone;
    private String email;

    public User(String firstname, String matricule, String lastname, String phone, String email) {
        this.firstname = firstname;
        this.matricule = matricule;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }
}
