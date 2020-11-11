package org.sid.web;

import org.sid.dao.EtudiantRepository;
import org.sid.entities.Etudiant;

import org.sid.service.AccountService;
import org.sid.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class EtudiantController {

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    AccountService accountService;

    @PostMapping("/etudiant/register")
    public Etudiant save(@RequestBody UserForm userForm) {
        return etudiantService.saveEtudiant(userForm);
    }


    @PutMapping("/etudiant/update")
    public Etudiant update(@RequestBody Etudiant etudiant) {
        //System.out.println(etudiant.getUsername());
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/etudiant/delete/{username}")
    public void delete(@PathVariable String username) {

        etudiantService.deleteEtudiant(username);
    }

//    @GetMapping("/etudiant/{username}")
//    public Etudiant find(@PathVariable String username){
//
//        return accountService.find(username) ;
//    }

}
