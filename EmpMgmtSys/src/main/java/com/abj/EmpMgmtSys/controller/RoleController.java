package com.abj.EmpMgmtSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.abj.EmpMgmtSys.model.Role;
import com.abj.EmpMgmtSys.service.RoleService;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public String listRoles(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "roles/list-roles";
    }

    @GetMapping("/form")
    public String showRoleForm(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "roles/role-form";
    }

    @PostMapping("/save")
    public String saveRole(@RequestParam("roleName") String roleName) {
        Role newRole = new Role(roleName);
        roleService.saveRole(newRole);
        return "redirect:/roles/list";
    }


    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        return "roles/role-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRoleById(id);
        return "redirect:/roles/list";
    }

    // Other role-related controller methods
}


