package com.example.demo.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.com.dao.RoleRepository;
import com.example.demo.com.dao.UserRepository;
import com.example.demo.com.entities.AppRole;
import com.example.demo.com.entities.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AppUser saveUser(AppUser u) {
	    u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
	return userRepository.save(u);
	}
	@Override
	public AppRole saveRole(AppRole r) {
	return roleRepository.save(r);
	}
	@Override
	public AppUser findUserByUsername(String username) {
	return userRepository.findByUsername(username);
	}
	@Override
	public void addRoleToUser(String username, String roleName) {
	AppUser user=userRepository.findByUsername(username);
	AppRole role=roleRepository.findByRoleName(roleName);
	user.getRoles().add(role);
	}

}
