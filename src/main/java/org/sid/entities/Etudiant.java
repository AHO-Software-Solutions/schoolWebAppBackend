package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant extends AppUser {

    @Column(unique = true)
    private String cne;
    private String firstname;
    private String lastname;
    private String filiere;
    private String email;
    private String num;
    private String numP;


}
