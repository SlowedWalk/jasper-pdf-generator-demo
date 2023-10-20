package tech.hidetora.pdfinvoice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceData {
    private String firstname;
    private String matricule;
    private String lastname;
    private String phone;
    private String email;
}
