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

import lms.domain.EvaluationAttending;
import lms.service.EvaluationAttendingService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/evaluationattending")
public class EvaluationAttendingController {

	@Autowired
	EvaluationAttendingService evaluationAttendingService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<EvaluationAttending>> getAllEvaluationAttending() {
		return new ResponseEntity<Iterable<EvaluationAttending>>(evaluationAttendingService.getAllEvaluationAttending(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<EvaluationAttending> getEvaluationAttendingById(@PathVariable Long id) {
		Optional<EvaluationAttending> evaluationAttending = evaluationAttendingService.getEvaluationAttendingId(id);
		if (evaluationAttending.isPresent()) {
			return new ResponseEntity<EvaluationAttending>(evaluationAttending.get(), HttpStatus.OK);
		}
		return new ResponseEntity<EvaluationAttending>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<EvaluationAttending> addEvaluationAttending(@RequestBody EvaluationAttending evaluationAttending) {

		evaluationAttendingService.addEvaluationAttending(evaluationAttending);
		return new ResponseEntity<EvaluationAttending>(evaluationAttending, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<EvaluationAttending> updateEvaluationAttending(@PathVariable Long id, @RequestBody EvaluationAttending evaluationAttending) {
		evaluationAttendingService.updateEvaluationAttending(id, evaluationAttending);
		return new ResponseEntity<EvaluationAttending>(evaluationAttending, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<EvaluationAttending> removeEvaluationAttending(@PathVariable Long id) {
		try {
			evaluationAttendingService.removeEvaluationAttending(id);
		} catch (Exception e) {
			return new ResponseEntity<EvaluationAttending>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<EvaluationAttending>(HttpStatus.NO_CONTENT);
	}
}
