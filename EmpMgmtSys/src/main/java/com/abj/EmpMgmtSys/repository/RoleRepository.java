package com.abj.EmpMgmtSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abj.EmpMgmtSys.model.Role;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
    List<Role> findAll(); // Add this method to fetch all roles
}
