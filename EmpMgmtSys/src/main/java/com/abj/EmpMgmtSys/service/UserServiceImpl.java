package com.abj.EmpMgmtSys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abj.EmpMgmtSys.model.User;
import com.abj.EmpMgmtSys.repository.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		// Encode the user's password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> userOptional = userRepository.findByUsername(username);
		return userOptional.orElse(null); // This returns null if the user is not found
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	// Other user-related methods can be implemented here
}
