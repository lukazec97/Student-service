package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Title;


@Repository
public interface TitleRepository extends JpaRepository<Title, Long>{

	

}
