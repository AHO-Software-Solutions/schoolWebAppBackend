package org.sid.web;

import lombok.Data;
import org.sid.entities.AppUser;
import org.sid.entities.Etudiant;
import org.sid.service.AccountService;
import org.sid.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
//    @Autowired
//    private AccountService accountService;
//
//    @PostMapping("/users")
//    public AppUser register(@RequestBody  UserForm userForm){
//        return  accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
//    }
//    @PutMapping("/users/update/{username}")
//    public AppUser updateUser(@RequestBody UserForm userForm,@PathVariable String username){
//         return accountService.updateUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),username);
//
//    }
//    @DeleteMapping("/users/delete/{username}")
//    public void deleteUser(@PathVariable String username){
//        accountService.deleteUser(username);
//    }


}
