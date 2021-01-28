package dto;

import entities.Course;
import entities.SchoolClass;

/**
 *
 * @author Malthe
 */
public class SchoolClassDTO {
    
    private long id;
    private String semester;
    private int numberOfStudents;
    
    private Course course;
    
    public SchoolClassDTO() {
    }
    
    public SchoolClassDTO(SchoolClass s) {
        this.id = s.getId();
        this.semester = s.getSemester();
        this.numberOfStudents = s.getNumberOfStudents();
        
        this.course = s.getCourse();
    }
    
    public SchoolClassDTO(String semester, int numberOfStudents, Course course) {
        this.semester = semester;
        this.numberOfStudents = numberOfStudents;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    
    
}
