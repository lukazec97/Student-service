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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import lms.domain.TitleType;
import lms.service.TitleTypeService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/titletype")
public class TitleTypeController {

	@Autowired
	TitleTypeService titleTypeService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<TitleType>> getAllTitleType() {
		return new ResponseEntity<Iterable<TitleType>>(titleTypeService.getAllTitleType(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<TitleType> getTitleTypeById(@PathVariable Long id) {
		Optional<TitleType> titleType = titleTypeService.getTitleTypeId(id);
		if (titleType.isPresent()) {
			return new ResponseEntity<TitleType>(titleType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<TitleType>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<TitleType> addTitleType(@RequestBody TitleType titleType) {

		titleTypeService.addTitleType(titleType);
		return new ResponseEntity<TitleType>(titleType, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<TitleType> updateTitleType(@PathVariable Long id, @RequestBody TitleType titleType) {
		titleTypeService.updateTitleType(id, titleType);
		return new ResponseEntity<TitleType>(titleType, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<TitleType> removeTitleType(@PathVariable Long id) {
		try {
			titleTypeService.removeTitleType(id);
		} catch (Exception e) {
			return new ResponseEntity<TitleType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TitleType>(HttpStatus.NO_CONTENT);
	}
}
