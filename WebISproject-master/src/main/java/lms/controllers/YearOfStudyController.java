package lms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import DTO.YearOfStudyDTO;
import lms.domain.StudyProgram;
import lms.domain.YearOfStudy;
import lms.repository.YearOfStudyRepository;
import lms.service.StudyProgramService;
import lms.service.YearOfStudyService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/yearofstudy")
public class YearOfStudyController {

	@Autowired
	YearOfStudyService yearOfStudyService;
	
	@Autowired
	StudyProgramService studyProgramService;
	
	@Autowired
	YearOfStudyRepository yearOfStudyRepository;

	@RequestMapping()
	public ResponseEntity<Iterable<YearOfStudyDTO>> getAllYearOfStudy() {
		return new ResponseEntity<Iterable<YearOfStudyDTO>>(yearOfStudyService.getAllYearOfStudy(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<YearOfStudyDTO> getYearOfStudyById(@PathVariable Long id) {
		Optional<YearOfStudy> yearOfStudy = yearOfStudyService.getYearOfStudyId(id);
		if (yearOfStudy.isPresent()) {
			return new ResponseEntity<YearOfStudyDTO>(yearOfStudy.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<YearOfStudyDTO>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<YearOfStudy> addYearOfStudy(@RequestBody YearOfStudy yearOfStudy) {
		
		yearOfStudyService.addYearOfStudy(yearOfStudy);
		return new ResponseEntity<YearOfStudy>(yearOfStudy, HttpStatus.CREATED);
	}
	

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<YearOfStudy> updateYearOfStudy(@PathVariable Long id, @RequestBody YearOfStudy yearOfStudy) {
		yearOfStudyService.updateYearOfStudy(id, yearOfStudy);
		return new ResponseEntity<YearOfStudy>(yearOfStudy, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<YearOfStudy> removeYearOfStudy(@PathVariable Long id) {
		try {
			yearOfStudyService.removeYearOfStudy(id);
		} catch (Exception e) {
			return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<YearOfStudy>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/file/upload")
	@Secured("ROLE_ADMIN")
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("numberOfYear") String numberOfYear, @RequestParam("studyProgram") String StudyProgram) {
		try {
			// save file to PostgreSQL
			StudyProgram sp = studyProgramService.getStudyProgramId(Long.valueOf(StudyProgram)).get();
			YearOfStudy filemode = new YearOfStudy(file, title, numberOfYear, sp);
			yearOfStudyRepository.save(filemode);
			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}
	
	@PostMapping(value = "/upload")
	@Secured("ROLE_ADMIN")
	public String addYearOfStudy2(@RequestParam("title") String title, @RequestParam("numberOfYear") String numberOfYear, @RequestParam("studyProgram") String StudyProgram) {
		try {
			StudyProgram sp = studyProgramService.getStudyProgramId(Long.valueOf(StudyProgram)).get();
			YearOfStudy yos = new YearOfStudy(title, numberOfYear, sp);
			yearOfStudyService.addYearOfStudy(yos);
			System.out.println("1");
			return "SUCCESS";
		} catch(Exception e) {
			System.out.println("2");
			return "FAIL";

		}
		
	}
}
