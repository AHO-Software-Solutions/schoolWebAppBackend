package org.sid.dao;

import org.sid.entities.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveillantRepository extends JpaRepository<Surveillant, Long> {
    public Surveillant findByUsername(String username);

}
