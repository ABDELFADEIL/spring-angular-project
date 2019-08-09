package com.example.demo.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.entities.AppUser;
import com.example.demo.com.entities.UserForm;
import com.example.demo.com.service.AccountService;


@RestController
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public AppUser signup(@RequestBody UserForm userForm) {
		AppUser appUser= accountService.findUserByUsername(userForm.getUsername());
		if(appUser!=null) throw new RuntimeException(userForm.getUsername() +" existe déjà");
		if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("Mot de passe n'est pas confirmé");
		AppUser u = new AppUser();
		u.setUsername(userForm.getUsername());
		u.setPassword(userForm.getPassword());
		accountService.saveUser(u);
		accountService.addRoleToUser(userForm.getUsername(), "USER");
		if(userForm.getUsername().equals("admin")) {
			accountService.addRoleToUser(userForm.getUsername(), "ADMIN");	
		}
		 return appUser;
	}
	
	
}
