package com.Ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Ecommerce.dao.RoleRepository;
import com.Ecommerce.dao.UserRepository;
import com.Ecommerce.entities.AppRole;
import com.Ecommerce.entities.AppUser;

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
		AppRole r=roleRepository.findByRoleName(roleName);
	    AppUser user=userRepository.findByUsername(username);
	    user.getRoles().add(r);
		 userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long idUser) {
	  	userRepository.deleteById(idUser);
	}


}
