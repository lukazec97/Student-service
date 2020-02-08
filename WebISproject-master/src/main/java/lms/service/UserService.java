package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import DTO.UserDTO;
import lms.domain.Administrator;
import lms.domain.User;
import lms.repository.UserRepository;

@Service
public class UserService implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdministratorService administratorService;
	
	@Autowired
	LoginService loginService;
	

	public Optional<User> getUser(String username) {
		return userRepository.getByUsername(username);
	}

	public Optional<User> getUser(String username, String password) {
		return userRepository.getByUsernameAndPassword(username, password);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public Iterable<UserDTO> getUsersDTO() {
		Iterable<User> c = userRepository.findAll();
		Set<UserDTO> cd = new HashSet<>();
		for(User ct: c)
			cd.add(ct.toDTO());
		return cd;
	}
	
	public void removeUserSoft(Long id) {
		Optional<User> u = userRepository.findById(id);
		if(u.isPresent()) {
			u.get().setDeleted(true);
			userRepository.save(u.get());
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		if(StreamSupport.stream(userRepository.findAll().spliterator(), false).count()<2)
		{
			User user = new User("admin", "admin", "ROLE_ADMIN");
			loginService.register(user);	
			Administrator admin = new Administrator("Pera", "Peric", user);		
			administratorService.addAdministrator(admin);
			
			User user2 = new User("plugin", "plugin", "ROLE_PLUGIN");
			loginService.register(user2);	
			
		}
	}
}