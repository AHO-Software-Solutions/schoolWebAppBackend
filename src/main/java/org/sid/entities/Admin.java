package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends AppUser {
    @Column(unique = true)
    private String code;
    private String firstname;
    private String lastname;
    private String email;
    private String num;

}
