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

import lms.domain.EvaluationType;
import lms.service.EvaluationTypeService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/evaluationtype")
public class EvaluationTypeController {

	@Autowired
	EvaluationTypeService evaluationTypeService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<EvaluationType>> getAllEvaluationType() {
		return new ResponseEntity<Iterable<EvaluationType>>(evaluationTypeService.getAllEvaluationType(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<EvaluationType> getEvaluationTypeById(@PathVariable Long id) {
		Optional<EvaluationType> evaluationType = evaluationTypeService.getEvaluationTypeId(id);
		if (evaluationType.isPresent()) {
			return new ResponseEntity<EvaluationType>(evaluationType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<EvaluationType>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<EvaluationType> addEvaluationType(@RequestBody EvaluationType evaluationType) {

		evaluationTypeService.addEvaluationType(evaluationType);
		return new ResponseEntity<EvaluationType>(evaluationType, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<EvaluationType> updateEvaluationType(@PathVariable Long id, @RequestBody EvaluationType evaluationType) {
		evaluationTypeService.updateEvaluationType(id, evaluationType);
		return new ResponseEntity<EvaluationType>(evaluationType, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<EvaluationType> removeEvaluationType(@PathVariable Long id) {
		try {
			evaluationTypeService.removeEvaluationType(id);
		} catch (Exception e) {
			return new ResponseEntity<EvaluationType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<EvaluationType>(HttpStatus.NO_CONTENT);
	}
}
