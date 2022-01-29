package com.raghava.jpa.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raghava.jpa.model.MyUserDetails;
import com.raghava.jpa.model.User;
import com.raghava.jpa.model.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		//MyUserDetails userDetails = new MyUserDetails(user.get());
		return user.map(MyUserDetails :: new).get();
	}

}
