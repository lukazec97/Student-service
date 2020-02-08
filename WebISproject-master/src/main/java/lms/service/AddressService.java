package lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Address;
import lms.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public AddressService() {}

	public Iterable<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	public void addAdress(Address a) {
		addressRepository.save(a);
	}

	public Optional<Address> getAddressId(Long id) {
		return addressRepository.findById(id);
	}

	public void removeAddress(Long id) {
		Optional<Address> a = addressRepository.findById(id);
		addressRepository.delete(a.get());
	}

	public void updateAddress(Long id, Address a) {
		Optional<Address> add = addressRepository.findById(id);
		if (add.isPresent()) {
			a.setId(add.get().getId());
			addressRepository.save(a);
		}
	}

}
