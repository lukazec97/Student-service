package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Outcome;
import lms.repository.OutcomeRepository;

@Service
public class OutcomeService {

	@Autowired
	OutcomeRepository outcomeRepository;

	public OutcomeService() {}
	
	public Iterable<Outcome> getAllOutcome() {
		return outcomeRepository.findAll();
	}

	public void addOutcome(Outcome o) {
		outcomeRepository.save(o);
	}

	public Optional<Outcome> getOutcomeId(Long id) {
		return outcomeRepository.findById(id);
	}

	public void removeOutcome(Long id) {
		Optional<Outcome> o = outcomeRepository.findById(id);
		outcomeRepository.delete(o.get());
	}

	public void updateOutcome(Long id, Outcome o) {
		Optional<Outcome> O = outcomeRepository.findById(id);
		if (O.isPresent()) {
			o.setId(O.get().getId());
			outcomeRepository.save(o);
		}
	}

}
