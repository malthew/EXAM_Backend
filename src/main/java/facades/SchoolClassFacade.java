package facades;

import dto.SchoolClassDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Malthe
 */
public class SchoolClassFacade {
    
    private static EntityManagerFactory emf;
    private static SchoolClassFacade instance;
    
    private SchoolClassFacade() {
    }
    
    public static SchoolClassFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SchoolClassFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<SchoolClassDTO> getAllClasses() {
        EntityManager em = emf.createEntityManager();
        try {
            List<SchoolClassDTO> list = em.createQuery("SELECT s FROM SchoolClass s ORDER BY s.semester ASC").getResultList();
            return list;
        } finally {
            em.close();
        }
    }
}
