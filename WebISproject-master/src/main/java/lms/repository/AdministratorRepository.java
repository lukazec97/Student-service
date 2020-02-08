package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Administrator;


@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

	

}
