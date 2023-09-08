package com.abj.EmpMgmtSys.service;

import com.abj.EmpMgmtSys.model.Role;
import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    Role findRoleById(Long id);
    Role findRoleByName(String name);
    List<Role> getAllRoles();
    void deleteRoleById(Long id);
    // Other role-related methods
}
