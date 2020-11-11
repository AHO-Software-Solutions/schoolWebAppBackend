package org.sid.service;

import org.sid.dao.AppUserRepository;
import org.sid.dao.ProfesseurRepository;
import org.sid.dao.SurveillantRepository;
import org.sid.entities.Professeur;
import org.sid.entities.Surveillant;
import org.sid.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SurveillantServiceImpl implements SurveillantService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    SurveillantRepository surveillantRepository;
    @Autowired
    AccountService accountService;

    @Override
    public Surveillant saveSurveillant(UserForm userForm) {
        if (!userForm.getPassword().equals(userForm.getConfirmedPassword()))
            throw new RuntimeException("Please confirm your password");
        Surveillant surveillant = surveillantRepository.findByUsername(userForm.getUsername());
        if (surveillant != null) throw new RuntimeException("User already exists");
        Surveillant s = new Surveillant();
        surveillantRepository.save(s);
        accountService.saveUser(s.getId(), userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
        accountService.addRoleToUser(userForm.getUsername(), "SURVEILLANT");
        return s;

    }

    @Override
    public Surveillant loadSurveillantByUsername(String username) {
        Surveillant surveillant = surveillantRepository.findByUsername(username);
        if (surveillant == null) throw new RuntimeException("user dont exist");
        return surveillant;
    }

    @Override
    public Surveillant updateSurveillant(Surveillant surveillant) {

        Surveillant s = surveillantRepository.findByUsername(surveillant.getUsername());
        if (s == null) throw new RuntimeException("User dont exists");
        s.setNum(surveillant.getNum());
        s.setEmail(surveillant.getEmail());
        s.setFirstname(surveillant.getFirstname());
        s.setLastname(surveillant.getLastname());
        s.setCode(surveillant.getCode());

        return s;
    }

    @Override
    public void deleteSurveillant(String username) {
        Surveillant surveillant = surveillantRepository.findByUsername(username);
        surveillantRepository.delete(surveillant);

    }
}
