package lms.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import DTO.TeacherDTO;
import DTO.TeacherXmlPojo;
import lms.domain.Course;
import lms.domain.CourseTeaching;
import lms.domain.Teacher;
import lms.domain.User;
import lms.repository.TeacherRepository;
import lms.utils.ConvertToPDF;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserService userService;

	@Autowired
	StorageService storageService;

	public TeacherService() {}
	
	public Iterable<TeacherDTO> getAllTeacher() {
		Iterable<Teacher> ts = teacherRepository.findAll();
		Set<TeacherDTO> ret = new HashSet<>();

		for(Teacher t: ts)
			ret.add(t.toDTO());
		
		return ret;
	}

	public void addTeacher(Teacher t) {
		teacherRepository.save(t);
	}

	public Optional<Teacher> getTeacherById(Long id) {
		return teacherRepository.findById(id);
	}

	public void removeTeacher(Long id) {
		Optional<Teacher> t = teacherRepository.findById(id);
		teacherRepository.delete(t.get());
	}
	
	public void removeTeacherSoft(Long id) {
		Optional<Teacher> t = teacherRepository.findById(id);
		if(t.isPresent()) {
			t.get().setDeleted(true);
			teacherRepository.save(t.get());
			Optional<User> u = userService.getUser(t.get().getUser().getUsername());
			if(u.isPresent()) {
				userService.removeUserSoft(u.get().getId());
			}
		}
	}

	public void updateTeacher(Long id, Teacher t) {
		Optional<Teacher> T = teacherRepository.findById(id);
		if (T.isPresent()) {
			t.setId(T.get().getId());
			t.setUser(T.get().getUser());
			teacherRepository.save(t);
		}
	}

	public Set<Course> getAllCourses(Teacher teacher) {

		Set<Course> ret = new HashSet<>();
		for (CourseTeaching courseTeaching : teacher.getCourseTeachings())
			ret.add(courseTeaching.getCourseRealization().getCourse());

		return ret;

	}
	
	public Iterable<Teacher> getByLastName(String lastName) {
		return teacherRepository.findByLastName(lastName);
	}
	
	public Iterable<Teacher> getByFirstName(String firstName) {
		return teacherRepository.findTeacherByFirstName(firstName);
	}
	
	public Optional<Teacher> getByPersonalIdentificationNumber(String personalIdentificationNumber) {
		return teacherRepository.findByPersonalIdentificationNumber(personalIdentificationNumber);
	}

	public Path toXMLFile(Teacher s) {
		File file = new File(s.getFirstName() + " " + s.getLastName() + " " + s.getPersonalIdentificationNumber() + ".xml");

		XmlMapper mapper = new XmlMapper();

		try {
			mapper.writeValue(file, s.toDTO());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file.toPath();
	}

	public Path allToXMLFile()
	{
		File file = new File("teachers.xml");
		
		XmlMapper mapper = new XmlMapper();
		


		

		

		try {
			mapper.writeValue(file, new TeacherXmlPojo(getAllTeacher()));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file.toPath();

	}

	public Resource allToPDF() throws FileNotFoundException {

		String filename = "teachers.pdf";

		return storageService.loadFile(ConvertToPDF.teachers(getAllTeacher(), filename));



		

	}

	public Resource toPDF(TeacherDTO s) {

		String filename = s.getFirstName() + " " + s.getLastName() + " " + s.getPersonalIdentificationNumber() + ".pdf";

		return storageService.loadFile(ConvertToPDF.teacher(s, filename));



		

	}

}
