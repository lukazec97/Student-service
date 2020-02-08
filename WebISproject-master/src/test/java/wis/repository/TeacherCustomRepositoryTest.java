package wis.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lms.domain.Teacher;
import lms.repository.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TeacherCustomRepositoryTest {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testCustomRepository() {
		List<Teacher> teachers = teacherRepository.findTeacherByFirstName("Stefan");
		assertEquals(teachers.size(), 1);
		teachers = teacherRepository.findByLastName("tef");
		assertEquals(teachers.size(), 1);
	}
}
