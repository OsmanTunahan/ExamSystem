package org.awoken.examsystem.dao;

import org.awoken.examsystem.model.Admin;

public interface AdminDAO {
    Admin getAdminByUsername(String username);
}