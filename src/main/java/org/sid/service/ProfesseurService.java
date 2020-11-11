package org.sid.service;

import org.sid.entities.Etudiant;
import org.sid.entities.Professeur;
import org.sid.web.UserForm;

public interface ProfesseurService {
    public Professeur saveProfesseur(UserForm userForm);

    public Professeur loadProfesseurByUsername(String username);

    public Professeur updateProfesseur(Professeur professeur);

    public void deleteProfesseur(String username);
}
