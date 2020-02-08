package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Address;
// cao
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	

}
