package lms.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Place;
import lms.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
	PlaceRepository placeRepository;

	public PlaceService() {}
	
	public Iterable<Place> getAllPlace() {
		return placeRepository.findAll();
	}

	public Optional<Place> getPlaceId(Long id) {
		return placeRepository.findById(id);
	}

	public void addPlace(Place p) {
		placeRepository.save(p);
	}

	public void removePlace(Long id) {
		Optional<Place> p = placeRepository.findById(id);
		placeRepository.delete(p.get());
	}

	public void updatePlace(Long id, Place p) {
		Optional<Place> P = placeRepository.findById(id);
		if (P.isPresent()) {
			p.setId(P.get().getId());
			placeRepository.save(p);
		}
	}

}
