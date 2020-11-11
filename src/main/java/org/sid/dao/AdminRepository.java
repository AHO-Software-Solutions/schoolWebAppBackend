package org.sid.dao;

import org.sid.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findByUsername(String username);
    public Admin findByEmail(String email);

}
