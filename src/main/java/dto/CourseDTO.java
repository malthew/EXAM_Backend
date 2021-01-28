package dto;

import entities.Course;
import java.util.List;

/**
 *
 * @author Malthe
 */
public class CourseDTO {
    private String name;
    private String description;
    private List<SchoolClassDTO> schoolClasses;
    
    //Constructor for making EsportDTOs with test data
    public CourseDTO(Course course) {
        this.name = course.getName();
        this.description = course.getDescription();
    }
    //Constructor for making EsportDTOs with data from a POST
    public CourseDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public CourseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SchoolClassDTO> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassDTO> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    @Override
    public String toString() {
        return "EsportDTO{" + "name=" + name + ", description=" + description + ", esportTeams=" + schoolClasses + '}';
    }
    
    
}
