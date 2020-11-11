package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(Long id, String username, String password, String confirmedPassword);

    public AppRole save(AppRole role);

    public AppUser loadUserByUsername(String username);

    public void addRoleToUser(String username, String rolename);

    public AppUser updateUser(String username, String password, String confirmedPassword, String username1);

    public void deleteUser(String username);
}
