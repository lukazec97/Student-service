package lms.controllers;



import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import DTO.AdminRegDTO;
import DTO.AdministratorDTO;
import DTO.LoginDTO;
import DTO.StudentDTO;
import DTO.StudentRegDTO;
import DTO.TeacherDTO;
import DTO.TeacherRegDTO;
import DTO.UserDTO;
import lms.domain.Administrator;
import lms.domain.Student;
import lms.domain.Teacher;
import lms.domain.User;
import lms.repository.TeacherRepository;
import lms.service.AdministratorService;
import lms.service.LoginService;
import lms.service.StudentService;
import lms.service.TeacherService;
import lms.service.UserService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class LoginController {
	
	
	
	
	@Autowired 
	LoginService loginService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	AdministratorService administratorService;
	
	@PostMapping(value = "/login")
	ResponseEntity<HashMap<String, String>> login(@RequestBody LoginDTO set) {
		
		Optional<User> user = userService.getUser(set.getUsername());
		
		if(user.isPresent())
		{
			return loginService.login(set);
		}
		
		return new ResponseEntity<HashMap<String,String>>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping(value = "/register")
	ResponseEntity<UserDTO> register(@RequestBody User user) {
		return loginService.register(user);
	}
	
	@PostMapping(value = "/register/student")
	ResponseEntity<StudentDTO> registerStudent(@RequestBody StudentRegDTO set) {
		
		
		User user = new User(set.getUsername(), set.getPassword(), set.getRole());
		
		loginService.register(user);
		
		Student student = new Student(set.getFirstname(), set.getLastname(), set.getCardnumber(), user);
		
		try {
			studentService.addStudent(student);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return new ResponseEntity<StudentDTO>(student.toDTO(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/register/teacher")
	ResponseEntity<TeacherDTO> registerTeacher(@RequestBody TeacherRegDTO set) {
		
		
		User user = new User(set.getUsername(), set.getPassword(), set.getRole());
		
		loginService.register(user);
		
		Teacher teacher = new Teacher(set.getFirstname(), set.getLastname(), set.getPersonalid(), user);
		
		teacherService.addTeacher(teacher);
		
		
		
		
		
		return new ResponseEntity<TeacherDTO>(teacher.toDTO(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/register/admin")
	ResponseEntity<AdministratorDTO> registerAdmin(@RequestBody AdminRegDTO set) {
		
		
		User user = new User(set.getUsername(), set.getPassword(), set.getRole());
		
		loginService.register(user);
		
		Administrator admin = new Administrator(set.getFirstname(), set.getLastname(), user);
		
		administratorService.addAdministrator(admin);
		
		
		
		
		
		return new ResponseEntity<AdministratorDTO>(admin.toDTO(), HttpStatus.OK);
	}
	
	@GetMapping("/test")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test success!", HttpStatus.OK);
	}
	
}