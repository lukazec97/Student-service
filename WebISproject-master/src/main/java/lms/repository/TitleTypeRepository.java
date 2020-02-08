package lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.TitleType;


@Repository
public interface TitleTypeRepository extends JpaRepository<TitleType, Long>{

	

}
