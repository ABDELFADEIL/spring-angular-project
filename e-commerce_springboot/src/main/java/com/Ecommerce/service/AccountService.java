package com.Ecommerce.service;

import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;

public interface AccountService {
	
	public AppUser saveUser(AppUser u);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public void addRoleToUser(String username, String roleName);

}
