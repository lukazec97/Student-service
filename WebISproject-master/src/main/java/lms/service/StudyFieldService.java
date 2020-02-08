package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.StudyField;
import lms.repository.StudyFieldRepository;

@Service
public class StudyFieldService {

	@Autowired
	StudyFieldRepository studyFieldRepository;
	
	public StudyFieldService() {}
	
	public Iterable<StudyField> getAllStudyField() {
		return studyFieldRepository.findAll();
	}

	public void addStudyField(StudyField s) {
		studyFieldRepository.save(s);
	}

	public Optional<StudyField> getStudyFieldId(Long id) {
		return studyFieldRepository.findById(id);
	}

	public void removeStudyField(Long id) {
		Optional<StudyField> s = studyFieldRepository.findById(id);
		studyFieldRepository.delete(s.get());
	}

	public void updateStudyField(Long id, StudyField sf) {
		Optional<StudyField> SF = studyFieldRepository.findById(id);
		if (SF.isPresent()) {
			sf.setId(SF.get().getId());
			studyFieldRepository.save(sf);
		}
	}

}
