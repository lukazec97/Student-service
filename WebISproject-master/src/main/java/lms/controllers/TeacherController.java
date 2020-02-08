package lms.controllers;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.TeacherDTO;
import lms.domain.Teacher;
import lms.service.StorageService;
import lms.service.TeacherService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@Autowired
	StorageService storageService;


	@RequestMapping()
	public ResponseEntity<Iterable<TeacherDTO>> getAllTeacher() {
		return new ResponseEntity<Iterable<TeacherDTO>>(teacherService.getAllTeacher(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
		Optional<Teacher> teacher = teacherService.getTeacherById(id);
		if (teacher.isPresent()) {
			return new ResponseEntity<TeacherDTO>(teacher.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {

		teacherService.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
		teacherService.updateTeacher(id, teacher);
		return new ResponseEntity<TeacherDTO>(teacher.toDTO(), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<TeacherDTO> removeTeacher(@PathVariable Long id) {
		try {
			teacherService.removeTeacherSoft(id);
		} catch (Exception e) {
			return new ResponseEntity<TeacherDTO>(teacherService.getTeacherById(id).get().toDTO(), HttpStatus.OK);
		}

		return new ResponseEntity<TeacherDTO>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/firstname/{firstName}")
	public ResponseEntity<Iterable<Teacher>> getTeacherByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<Iterable<Teacher>>(teacherService.getByFirstName(firstName), HttpStatus.OK);
	}
	
	@GetMapping(value = "/lastname/{lastName}")
	public ResponseEntity<Iterable<Teacher>> getTeacherByLastName(@PathVariable String lastName) {
		return new ResponseEntity<Iterable<Teacher>>(teacherService.getByLastName(lastName), HttpStatus.OK);
	}
	
	@GetMapping(value = "/personaidentificationnumber/{personalIdentificationNumber}")
	public ResponseEntity<Teacher> getTeacherByPersonalIdentificationNumber(@PathVariable String personalIdentificationNumber) {
		Optional<Teacher> teacher = teacherService.getByPersonalIdentificationNumber(personalIdentificationNumber);
		if(teacher.isPresent()) {
			return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/downloadxml")
	public ResponseEntity<Resource>downloadAllTeachersXML()
	{
	
		
		Resource file = storageService.loadFile(teacherService.allToXMLFile());
    	return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  		
		
	}

	@GetMapping(value = "/downloadxml/{id}")
	public ResponseEntity<Resource>downloadTeacherXML(@PathVariable Long id)
	{
	
		Optional<Teacher> teacher = teacherService.getTeacherById(id);
		if(teacher.isPresent())
		{
			Resource file = storageService.loadFile(teacherService.toXMLFile(teacher.get()));
    	return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  		}
		
		return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		
	}

	
	@GetMapping(value = "/downloadpdf")
	public ResponseEntity<Resource>downloadTeachersPDF() throws FileNotFoundException
	{
	
		
		Resource file = teacherService.allToPDF();
    	return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  		
		
	}

	@GetMapping(value = "/downloadpdf/{id}")
	public ResponseEntity<Resource>downloadStudentPDF(@PathVariable Long id)
	{
	
		
		Optional<Teacher> teacher = teacherService.getTeacherById(id);
		if(teacher.isPresent())
		{
			Resource file = teacherService.toPDF(teacher.get().toDTO());
    		return ResponseEntity.ok()
        		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        		.body(file);
  		}
		  
		  return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		
	}
	
	
}
