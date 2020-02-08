package lms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lms.domain.Teacher;


@Repository
@Transactional(readOnly = true)
public class TeacherRepositoryCustomImpl implements TeacherRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
	
	@Override
	public List<Teacher> findByLastName(String lastName) {
		Query query = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.lastName like :ln", Teacher.class);
		query.setParameter("ln", "%"+lastName+"%");
		return query.getResultList();
	}

}
