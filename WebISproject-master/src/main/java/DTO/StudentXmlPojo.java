package DTO;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StudentXmlPojo
{
    
    @JacksonXmlElementWrapper(localName = "students")
    @JacksonXmlProperty(localName = "student")
    Iterable<StudentDTO> students;


    public StudentXmlPojo() {
    }

    public StudentXmlPojo(Iterable<StudentDTO> students) {
        this.students = students;
    }

    public Iterable<StudentDTO> getStudents() {
        return this.students;
    }

    public void setStudents(Iterable<StudentDTO> students) {
        this.students = students;
    }

    public StudentXmlPojo students(Iterable<StudentDTO> students) {
        this.students = students;
        return this;
    }

    

    @Override
    public String toString() {
        return "{" +
            " students='" + getStudents() + "'" +
            "}";
    }

    

}