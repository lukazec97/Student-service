package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.StudyProgramDTO;
import lms.domain.StudyProgram;
import lms.repository.StudyProgramRepository;

@Service
public class StudyProgramService {
	
	@Autowired
	StudyProgramRepository studyProgramRepository;
	
	public StudyProgramService() {}
	
	public Iterable<StudyProgramDTO> getAllStudyProgram() {
		
		
		Iterable<StudyProgram> sps = studyProgramRepository.findAll();
		Set<StudyProgramDTO> ret = new HashSet<>();
		for(StudyProgram sp: sps)
			ret.add(sp.toDTO());
		
		return ret;	
	}

	public void addStudyProgram(StudyProgram s) {
		studyProgramRepository.save(s);
	}

	public Optional<StudyProgram> getStudyProgramId(Long id) {
		return studyProgramRepository.findById(id);
	}

	public void removeStudyProgram(Long id) {
		Optional<StudyProgram> s = studyProgramRepository.findById(id);
		studyProgramRepository.delete(s.get());
	}
	
	public void updateStudyProgram(Long id, StudyProgram sp) {
		Optional<StudyProgram> SP = studyProgramRepository.findById(id);
		if (SP.isPresent()) {
			sp.setId(SP.get().getId());
			studyProgramRepository.save(sp);
		}
	}
	
	public Iterable<StudyProgram> getStudyProgramByName(String name) {
		return studyProgramRepository.findByName(name);
	}


}
