package facades;

import dto.CourseDTO;
import entities.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Malthe
 */
public class CourseFacade {
    
    private static EntityManagerFactory emf;
    private static CourseFacade instance;
    
    private CourseFacade() {
    }
    
    public static CourseFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void populateDB() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Course.deleteAllRows").executeUpdate();
            em.persist(new Course("Artificial Intelligence", "Also known as 'AI'. A subject that is getting bigger every year."));
            em.persist(new Course("Mobile Apps", "Teaches you how to plan, design and develop your own mobile apps for various operating systems."));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public long getCourseCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long courseCount = (long)em.createQuery("SELECT COUNT(c) FROM Course c").getSingleResult();
            return courseCount;
        }finally{
            em.close();
        }
    }
    
    public List<CourseDTO> getAllCourses() {
        EntityManager em = emf.createEntityManager();
        try {
            List<CourseDTO> list = em.createQuery("SELECT c FROM Course c ORDER BY c.name ASC").getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    
//    public List<EsportDTO> getAllEsports() {
//        EntityManager em = emf.createEntityManager();
//    }
}
