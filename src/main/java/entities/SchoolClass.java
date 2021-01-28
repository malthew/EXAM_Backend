package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Malthe
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SchoolClass.deleteAllRows", query = "DELETE from SchoolClass"),
    @NamedQuery(name = "SchoolClass.getAllRows", query = "SELECT s from SchoolClass s")
})
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String semester;
    private int numberOfStudents;
    
    @ManyToOne(cascade = { CascadeType.PERSIST })
    private Course course;
    
//    @ManyToOne(cascade = { CascadeType.PERSIST })
//    private Teacher teacher;
    
    public SchoolClass() {
    }
    
//    For adding just a class
    public SchoolClass(String semester, int numberOfStudents) {
        this.semester = semester;
        this.numberOfStudents = numberOfStudents;
    }
    
//    For adding a class with an existing course
    public SchoolClass(String semester, int numberOfStudents, Course course) {
        this.semester = semester;
        this.numberOfStudents = numberOfStudents;
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (course != null) {
            this.course = course;
        } else {
            this.course = null;
        }
    }
    
    
}
