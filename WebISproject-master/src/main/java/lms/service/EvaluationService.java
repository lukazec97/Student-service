package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Evaluation;
import lms.repository.EvaluationRepository;

@Service
public class EvaluationService {

	public  EvaluationService() {}
	
	@Autowired
	EvaluationRepository evaluationRepository;

	public Iterable<Evaluation> getAllEvaluation() {
		return evaluationRepository.findAll();
	}

	public void addEvaluation(Evaluation c) {
		evaluationRepository.save(c);
	}

	public Optional<Evaluation> getEvaluationId(Long id) {
		return evaluationRepository.findById(id);
	}

	public void removeEvaluation(Long id) {
		Optional<Evaluation> c = evaluationRepository.findById(id);
		evaluationRepository.delete(c.get());
	}

	public void updateEvaluation(Long id, Evaluation cr) {
		Optional<Evaluation> CR = evaluationRepository.findById(id);
		if (CR.isPresent()) {
			cr.setId(CR.get().getId());
			evaluationRepository.save(cr);
		}
	}
	
	
}
