package com.Ecommerce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dao.PanierRepository;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;
import com.Ecommerce.entities.UserForm;
import com.Ecommerce.service.AccountService;
import com.Ecommerce.service.PanierService;

@CrossOrigin("*")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository repository;
	@Autowired
	private PanierService panierService;
	

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
		AppUser user = null;
		try {	
		    user = accountService.saveUser(u);
			//AppRole role =repository.findByRoleName("USER");
			panierService.CreatePanier(user.getId());
			accountService.saveUser(user);
			accountService.addRoleToUser(username, "USER");
		} catch (Exception e) {
			System.out.println("error de sevgarde ");
		}
		return user;
	}
	
	@PutMapping("/modifier")
	public AppUser modifierDetail(@RequestBody AppUser user) {
		return userRepository.save(user);
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
	@GetMapping("/user-info")
	public AppUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
			return accountService.findUserByUsername(username);
		} else {
		  String username = principal.toString();
			return accountService.findUserByUsername(username);

		}

	}
	

}
