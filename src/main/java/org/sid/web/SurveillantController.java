package org.sid.web;

import org.sid.entities.Professeur;
import org.sid.entities.Surveillant;
import org.sid.service.ProfesseurServiceImpl;
import org.sid.service.SurveillantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveillantController {
    @Autowired
    SurveillantService surveillantService;

    @PostMapping("/surveillant/register")
    public Surveillant save(@RequestBody UserForm userForm) {
        return surveillantService.saveSurveillant(userForm);
    }


    @PutMapping("/surveillant/update")
    public Surveillant update(@RequestBody Surveillant surveillant) {
        return surveillantService.updateSurveillant(surveillant);
    }

    @DeleteMapping("/surveillant/delete/{username}")
    public void delete(@PathVariable String username) {
        surveillantService.deleteSurveillant(username);
    }
}
