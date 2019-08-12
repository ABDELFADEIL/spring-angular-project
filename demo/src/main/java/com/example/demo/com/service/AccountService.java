package com.example.demo.com.service;

import com.example.demo.com.entities.AppRole;
import com.example.demo.com.entities.AppUser;

public interface AccountService {

	public AppUser saveUser(AppUser u);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public void addRoleToUser(String username,String role);
}
