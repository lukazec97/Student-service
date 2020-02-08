package wis.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lms.domain.Student;
import lms.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void studentCrud() {
		Student student = new Student();
		student.setFirstName("Pera");
		student.setLastName("Peric");
		student.setCardNumber("123321");
		
		// insert the student
		student = studentRepository.save(student);
		// after persisting the student, the id should not be null		
		assertNotNull(student.getId());
		
		List<Student> fetchedStudents = studentRepository.findAll();
		// there should be exactly one student in the database
		assertEquals(fetchedStudents.size(), 2);
		
		// update
		student.setFirstName("Marko");
		studentRepository.save(student);
		studentRepository.flush();
		// the students first name should have been changed
		assertEquals(studentRepository.findByFirstNameLikeIgnoreCase("Marko").size(), 1);
		
		// the application supports logical delete
		studentRepository.deleteById(student.getId());
		// flush forces changes to be instantly applied to the DB
		studentRepository.flush();
		
		assertEquals(studentRepository.findAll().size(), 1);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void studentQueryMethods() {
		Student student = new Student();
		student.setFirstName("Pera");
		student.setLastName("Peric");
		student.setCardNumber("123321");
		
		// insert the student
		student = studentRepository.save(student);
		// after persisting the student, the id should not be null		
		assertNotNull(student.getId());
		List<Student> students = studentRepository.findByFirstNameLikeIgnoreCase("%er%");
		assertEquals(students.size(), 1);
		students = studentRepository.findByCourseAttendingsCourseRealizationCourseTitle("Objektno orjentisano programiranje");
		assertEquals(students.size(), 1);
	}
	
}
