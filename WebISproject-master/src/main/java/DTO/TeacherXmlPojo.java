package DTO;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TeacherXmlPojo
{
    
    @JacksonXmlElementWrapper(localName = "teachers")
    @JacksonXmlProperty(localName = "teacher")
    Iterable<TeacherDTO> teachers;


    public TeacherXmlPojo() {
    }

    public TeacherXmlPojo(Iterable<TeacherDTO> teachers) {
        this.teachers = teachers;
    }

    public Iterable<TeacherDTO> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(Iterable<TeacherDTO> teachers) {
        this.teachers = teachers;
    }

    public TeacherXmlPojo teachers(Iterable<TeacherDTO> teachers) {
        this.teachers = teachers;
        return this;
    }

    

    @Override
    public String toString() {
        return "{" +
            " teachers='" + getTeachers() + "'" +
            "}";
    }

    

}