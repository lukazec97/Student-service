package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.EvaluationType;
import lms.repository.EvaluationTypeRepository;

@Service
public class EvaluationTypeService {

	public  EvaluationTypeService() {}
	
	@Autowired
	EvaluationTypeRepository evaluationTypeRepository;

	public Iterable<EvaluationType> getAllEvaluationType() {
		return evaluationTypeRepository.findAll();
	}

	public void addEvaluationType(EvaluationType c) {
		evaluationTypeRepository.save(c);
	}

	public Optional<EvaluationType> getEvaluationTypeId(Long id) {
		return evaluationTypeRepository.findById(id);
	}

	public void removeEvaluationType(Long id) {
		Optional<EvaluationType> c = evaluationTypeRepository.findById(id);
		evaluationTypeRepository.delete(c.get());
	}

	public void updateEvaluationType(Long id, EvaluationType cr) {
		Optional<EvaluationType> CR = evaluationTypeRepository.findById(id);
		if (CR.isPresent()) {
			cr.setId(CR.get().getId());
			evaluationTypeRepository.save(cr);
		}
	}
	
	
}
