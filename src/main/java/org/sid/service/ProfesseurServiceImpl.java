package org.sid.service;

import org.sid.dao.AppUserRepository;
import org.sid.dao.ProfesseurRepository;
import org.sid.dao.ProfesseurRepository;
import org.sid.entities.AppUser;
import org.sid.entities.Etudiant;
import org.sid.entities.Professeur;
import org.sid.entities.Professeur;
import org.sid.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfesseurServiceImpl implements ProfesseurService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    AccountService accountService;

    @Override
    public Professeur saveProfesseur(UserForm userForm) {

        if (!userForm.getPassword().equals(userForm.getConfirmedPassword()))
            throw new RuntimeException("Please confirm your password");
        Professeur professeur = professeurRepository.findByUsername(userForm.getUsername());
        if (professeur != null) throw new RuntimeException("User already exists");
        Professeur p = new Professeur();

        professeurRepository.save(p);
        accountService.saveUser(p.getId(), userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
        accountService.addRoleToUser(userForm.getUsername(), "PROFESSEUR");
        return p;
    }

    @Override
    public Professeur loadProfesseurByUsername(String username) {
        Professeur professeur = professeurRepository.findByUsername(username);
        if (professeur == null) throw new RuntimeException("user dont exist");
        return professeur;
    }

    @Override
    public Professeur updateProfesseur(Professeur professeur) {
        Professeur p = professeurRepository.findByUsername(professeur.getUsername());
        if (p == null) throw new RuntimeException("User dont exists");
        p.setNum(professeur.getNum());
        p.setEmail(professeur.getEmail());
        p.setFirstname(professeur.getFirstname());
        p.setLastname(professeur.getLastname());
        p.setCode(professeur.getCode());
        p.setMatriere(professeur.getMatriere());
        return p;
    }

    @Override
    public void deleteProfesseur(String username) {
        Professeur professeur = professeurRepository.findByUsername(username);
        professeurRepository.delete(professeur);

    }
}
