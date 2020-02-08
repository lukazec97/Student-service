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

import lms.domain.Place;
import lms.service.PlaceService;
import lms.utils.View.HideOptionalProperties;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceService placeService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping
	public ResponseEntity<Iterable<Place>> getAllPlace() {
		return new ResponseEntity<Iterable<Place>>(placeService.getAllPlace(), HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<Place> getPlace(@PathVariable Long id) {
		Optional<Place> place = placeService.getPlaceId(id);
		if (place.isPresent()) {
			return new ResponseEntity<Place>(place.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Place> addPlace(@RequestBody Place place) {
		placeService.addPlace(place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place place) {
		placeService.updatePlace(id, place);
		return new ResponseEntity<Place>(place, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Place> removePlace(@PathVariable Long id) {
		try {
			placeService.removePlace(id);
		} catch (Exception e) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
	}
}
