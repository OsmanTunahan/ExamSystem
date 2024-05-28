package org.awoken.examsystem.service;

import org.awoken.examsystem.dao.AdminDAO;
import org.awoken.examsystem.model.Admin;

public class AdminService {
    private final AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Admin getAdminByUsername(String username) {
        return adminDAO.getAdminByUsername(username);
    }
}
