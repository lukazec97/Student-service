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

import DTO.CenterDTO;
import lms.domain.Center;
import lms.repository.CenterRepository;
import lms.service.CenterService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/center")
public class CenterController {

	@Autowired
	CenterService centerService;

	@Autowired
	CenterRepository centerRepository;

	@GetMapping()
	public ResponseEntity<Iterable<CenterDTO>> getCenters() {
		return new ResponseEntity<Iterable<CenterDTO>>(centerService.getAllCenter(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CenterDTO> getCenter(@PathVariable Long id) {
		Optional<Center> center = centerService.getCenterId(id);
		if (center.isPresent()) {
			return new ResponseEntity<CenterDTO>(center.get().toDTO(), HttpStatus.OK);
		}
		return new ResponseEntity<CenterDTO>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Center> addCenter(@RequestBody Center center) {

		centerService.addCenter(center);
		return new ResponseEntity<Center>(center, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Center> updateCenter(@PathVariable Long id, @RequestBody Center center) {
		centerService.updateCenter(id, center);
		return new ResponseEntity<Center>(center, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Center> removeCenter(@PathVariable Long id) {
		try {
			centerService.removeCenter(id);
		} catch (Exception e) {
			return new ResponseEntity<Center>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Center>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/file/upload")
	@Secured("ROLE_ADMIN")
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
		try {
			// save file to PostgreSQL
			Center filemode = new Center(file, name);
			centerRepository.save(filemode);
			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}

}
