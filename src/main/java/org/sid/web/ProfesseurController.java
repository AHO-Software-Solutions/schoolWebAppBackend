package org.sid.web;

import org.sid.entities.Etudiant;
import org.sid.entities.Professeur;
import org.sid.service.EtudiantServiceImpl;
import org.sid.service.ProfesseurService;
import org.sid.service.ProfesseurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfesseurController {
    @Autowired
    ProfesseurService professeurService;

    @PostMapping("/professeur/register")
    public Professeur save(@RequestBody UserForm userForm) {
        return professeurService.saveProfesseur(userForm);
    }


    @PutMapping("/professeur/update")
    public Professeur update(@RequestBody Professeur professeur) {
        return professeurService.updateProfesseur(professeur);
    }

    @DeleteMapping("/professeur/delete/{username}")
    public void delete(@PathVariable String username) {
        professeurService.deleteProfesseur(username);
    }
}
