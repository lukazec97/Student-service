package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

	

}
