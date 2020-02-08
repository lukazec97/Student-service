package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.YearOfStudyDTO;
import lms.domain.YearOfStudy;
import lms.repository.YearOfStudyRepository;

@Service
public class YearOfStudyService {

	@Autowired
	YearOfStudyRepository yearOfStudyRepository;

	public YearOfStudyService() {}

	public Iterable<YearOfStudyDTO> getAllYearOfStudy() {
		Iterable<YearOfStudy> yoss = yearOfStudyRepository.findAll();
		Set<YearOfStudyDTO> ret = new HashSet<>();
		for(YearOfStudy yos: yoss)
			ret.add(yos.toDTO());
		return ret;
	}

	public void addYearOfStudy(YearOfStudy y) {
		yearOfStudyRepository.save(y);
	}

	public Optional<YearOfStudy> getYearOfStudyId(Long id) {
		return yearOfStudyRepository.findById(id);
	}

	public void removeYearOfStudy(Long id) {
		Optional<YearOfStudy> y = yearOfStudyRepository.findById(id);
		yearOfStudyRepository.delete(y.get());
	}

	public void updateYearOfStudy(Long id, YearOfStudy yos) {
		Optional<YearOfStudy> YOS = yearOfStudyRepository.findById(id);
		if (YOS.isPresent()) {
			yos.setId(YOS.get().getId());
			yearOfStudyRepository.save(yos);
		}
	}

}
