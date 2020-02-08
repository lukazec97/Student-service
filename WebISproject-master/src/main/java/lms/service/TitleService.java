package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Title;
import lms.repository.TitleRepository;

@Service
public class TitleService {

	@Autowired
	TitleRepository titleRepository;
	
	public TitleService() {}
	
	public Iterable<Title> getAllTitle() {
		return titleRepository.findAll();
	}

	public void addTitle(Title t) {
		titleRepository.save(t);
	}

	public Optional<Title> getTitleId(Long id) {
		return titleRepository.findById(id);
	}

	public void removeTitle(Long id) {
		Optional<Title> t = titleRepository.findById(id);
		titleRepository.delete(t.get());
	}

	public void updateTitle(Long id, Title t) {
		Optional<Title> T = titleRepository.findById(id);
		if (T.isPresent()) {
			t.setId(T.get().getId());
			titleRepository.save(t);
		}
	}

}
