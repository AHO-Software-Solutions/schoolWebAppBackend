package org.sid.service;

import org.sid.entities.Admin;
import org.sid.web.UserForm;

public interface AdminService {
    public Admin saveAdmin(UserForm userForm);

    public Admin loadAdminByUsername(String username);

    public Admin updateAdmin(Admin admin);

    public void deleteAdmin(String username);
}
