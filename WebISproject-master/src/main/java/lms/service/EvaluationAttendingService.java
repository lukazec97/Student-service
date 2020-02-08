package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.EvaluationAttending;
import lms.repository.EvaluationAttendingRepository;

@Service
public class EvaluationAttendingService {

	public  EvaluationAttendingService() {}
	
	@Autowired
	EvaluationAttendingRepository evaluationAttendingRepository;

	public Iterable<EvaluationAttending> getAllEvaluationAttending() {
		return evaluationAttendingRepository.findAll();
	}

	public void addEvaluationAttending(EvaluationAttending c) {
		evaluationAttendingRepository.save(c);
	}

	public Optional<EvaluationAttending> getEvaluationAttendingId(Long id) {
		return evaluationAttendingRepository.findById(id);
	}

	public void removeEvaluationAttending(Long id) {
		Optional<EvaluationAttending> c = evaluationAttendingRepository.findById(id);
		evaluationAttendingRepository.delete(c.get());
	}

	public void updateEvaluationAttending(Long id, EvaluationAttending cr) {
		Optional<EvaluationAttending> CR = evaluationAttendingRepository.findById(id);
		if (CR.isPresent()) {
			cr.setId(CR.get().getId());
			evaluationAttendingRepository.save(cr);
		}
	}
	
	
}
