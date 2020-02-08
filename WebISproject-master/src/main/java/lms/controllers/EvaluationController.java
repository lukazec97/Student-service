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

import lms.domain.Evaluation;
import lms.service.EvaluationService;
import lms.utils.View.HideOptionalProperties;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	EvaluationService evaluationService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Evaluation>> getAllEvaluation() {
		return new ResponseEntity<Iterable<Evaluation>>(evaluationService.getAllEvaluation(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<Evaluation> getEvaluationById(@PathVariable Long id) {
		Optional<Evaluation> evaluation = evaluationService.getEvaluationId(id);
		if (evaluation.isPresent()) {
			return new ResponseEntity<Evaluation>(evaluation.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Evaluation>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	//@Secured("ROLE_ADMIN")
	public ResponseEntity<Evaluation> addEvaluation(@RequestBody Evaluation evaluation) {

		evaluationService.addEvaluation(evaluation);
		return new ResponseEntity<Evaluation>(evaluation, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long id, @RequestBody Evaluation evaluation) {
		evaluationService.updateEvaluation(id, evaluation);
		return new ResponseEntity<Evaluation>(evaluation, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Evaluation> removeEvaluation(@PathVariable Long id) {
		try {
			evaluationService.removeEvaluation(id);
		} catch (Exception e) {
			return new ResponseEntity<Evaluation>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Evaluation>(HttpStatus.NO_CONTENT);
	}
}
