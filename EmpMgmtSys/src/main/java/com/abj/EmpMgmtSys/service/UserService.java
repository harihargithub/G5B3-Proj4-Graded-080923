package com.abj.EmpMgmtSys.service;

import java.util.List;

import com.abj.EmpMgmtSys.model.User;

public interface UserService {
	
	User saveUser(User user);
    User findUserById(Long id);
    User findByUsername(String username);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    // Other user-related methods

}
