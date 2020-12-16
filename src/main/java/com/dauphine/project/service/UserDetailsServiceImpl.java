package com.dauphine.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.dauphine.project.entity.Role;
import com.dauphine.project.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
	
    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

    	// Recherchez l'utilisateur avec le référentiel et s'il n'existe pas, lancez une exception
    	com.dauphine.project.entity.User appUser = 
                 userRepository.findByUsername(username);
		

    // Associez notre liste d'autorités à celle de spring security 
    List grantList = new ArrayList();
    for (Role role: appUser.getRole()) {
        // ROLE_USER, ROLE_ADMIN,..
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            grantList.add(grantedAuthority);
    }
		
    // Créez l'objet UserDetails qui va aller en session et retournez-le.
    UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
         return user;

    }
}

