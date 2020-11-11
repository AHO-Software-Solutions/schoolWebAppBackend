package org.sid.web;

import org.sid.entities.Admin;
import org.sid.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;




    @PostMapping("/admin/register")
    public Admin save(@RequestBody UserForm userForm) {
        return adminService.saveAdmin(userForm);
    }


    @PutMapping("/admin/update")
    public Admin update(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/admin/delete/{username}")
    public void delete(@PathVariable String username) {
        adminService.deleteAdmin(username);
    }
}
