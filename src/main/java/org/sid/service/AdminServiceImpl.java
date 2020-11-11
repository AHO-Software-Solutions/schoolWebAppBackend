package org.sid.service;

import org.sid.dao.AppUserRepository;
import org.sid.dao.AdminRepository;
import org.sid.entities.Admin;
import org.sid.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountService accountService;

    @Override
    public Admin saveAdmin(UserForm userForm) {
        if (!userForm.getPassword().equals(userForm.getConfirmedPassword()))
            throw new RuntimeException("Please confirm your password");
        Admin Admin = adminRepository.findByUsername(userForm.getUsername());
        if (Admin != null) throw new RuntimeException("User already exists");
        Admin a = new Admin();
        adminRepository.save(a);
        accountService.saveUser(a.getId(), userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
        accountService.addRoleToUser(userForm.getUsername(), "ADMIN");
        return a;

    }

    @Override
    public Admin loadAdminByUsername(String username) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) throw new RuntimeException("user dont exist");
        return admin;
    }

    @Override
    public Admin updateAdmin(Admin admin) {

        Admin a = adminRepository.findByUsername(admin.getUsername());
        if (a == null) throw new RuntimeException("User dont exists");
        a.setNum(admin.getNum());
        a.setEmail(admin.getEmail());
        a.setFirstname(admin.getFirstname());
        a.setLastname(admin.getLastname());
        a.setCode(admin.getCode());
        return a;
    }

    @Override
    public void deleteAdmin(String username) {
        Admin admin = adminRepository.findByUsername(username);
        adminRepository.delete(admin);

    }
}
