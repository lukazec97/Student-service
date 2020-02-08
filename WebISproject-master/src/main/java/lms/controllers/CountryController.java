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

import lms.domain.Country;
import lms.service.CountryService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@RequestMapping()
	public ResponseEntity<Iterable<Country>> getAllCountry() {
		return new ResponseEntity<Iterable<Country>>(countryService.getAllCountry(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Optional<Country> country = countryService.getCountryId(id);
		if (country.isPresent()) {
			return new ResponseEntity<Country>(country.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {

		countryService.addCountry(country);
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country) {
		countryService.updateCountry(id, country);
		return new ResponseEntity<Country>(country, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Country> removeCountry(@PathVariable Long id) {
		try {
			countryService.removeCountry(id);
		} catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}

}