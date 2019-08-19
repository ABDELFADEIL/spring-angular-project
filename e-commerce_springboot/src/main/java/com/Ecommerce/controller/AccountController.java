package com.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.UserForm;
import com.Ecommerce.service.AccountService;

@CrossOrigin("*")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository repository;
	
	@PostMapping("/signup")
	public AppUser signup(@RequestBody UserForm userForm) {
		String password=userForm.getPassword();
		String repassword=userForm.getRepassword();
		if(!(repassword.equals(password))) throw new RuntimeException(repassword+ " Mot de passe n'est pas confirmé");
		String username = userForm.getUsername();
		AppUser appUser= userRepository.findByUsername(username);
		if(appUser!=null) throw new RuntimeException(userForm.getUsername() +" existe déjà");
		AppUser u = new AppUser();
		u.setUsername(username);
		u.setPassword(password);
		accountService.saveUser(u);
	    AppRole role =repository.findByRoleName("USER");
		accountService.addRoleToUser(username, role.getRoleName());

		return (u);
	}
	

}
