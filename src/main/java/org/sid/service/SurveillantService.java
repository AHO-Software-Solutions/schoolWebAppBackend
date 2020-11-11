package org.sid.service;

import org.sid.entities.Professeur;
import org.sid.entities.Surveillant;
import org.sid.web.UserForm;

public interface SurveillantService {
    public Surveillant saveSurveillant(UserForm userForm);

    public Surveillant loadSurveillantByUsername(String username);

    public Surveillant updateSurveillant(Surveillant surveillant);

    public void deleteSurveillant(String username);
}
