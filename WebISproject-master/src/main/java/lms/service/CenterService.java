package lms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.CenterDTO;
import lms.domain.Center;
import lms.repository.CenterRepository;

@Service
public class CenterService {
	
	public CenterService() {}
	
	@Autowired
	CenterRepository centerRepository;
	
	public Iterable<CenterDTO> getAllCenter() {
		Iterable<Center> c = centerRepository.findAll();
		Set<CenterDTO> cd = new HashSet<>();
		for(Center ct: c)
			cd.add(ct.toDTO());
		return cd;
	}
	
	public void addCenter(Center c) {
		centerRepository.save(c);
	}

	public Optional<Center> getCenterId(Long id) {
		return centerRepository.findById(id);
	}

	public void removeCenter(Long id) {
		Optional<Center> c = centerRepository.findById(id);
		centerRepository.delete(c.get());
	}

	public void updateCenter(Long id, Center c) {
		Optional<Center> cou = centerRepository.findById(id);
		if (cou.isPresent()) {
			c.setId(cou.get().getId());
			centerRepository.save(c);
		}
	}
}
