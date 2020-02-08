package lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.UserDTO;
import lms.domain.User;
import lms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired()
	UserService userService;

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<User> addUser(@RequestBody User user) {

		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	/*
	//@JsonView(HideOptionalProperties.class)
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		return new ResponseEntity<Iterable<User>>(userService.getUsers(), HttpStatus.OK);
	}*/
	
	@GetMapping
	public ResponseEntity<Iterable<UserDTO>> getUsers() {
		return new ResponseEntity<Iterable<UserDTO>>(userService.getUsersDTO(), HttpStatus.OK);
	}

}