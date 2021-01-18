package facades;

import dto.EsportDTO;
import entities.Esport;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Malthe
 */
public class EsportFacade {
    
    private static EntityManagerFactory emf;
    private static EsportFacade instance;
    
    private EsportFacade() {
    }
    
    public static EsportFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EsportFacade();
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
            em.createNamedQuery("Esport.deleteAllRows").executeUpdate();
            em.persist(new Esport("Counter-strike: Global Offensive", "The biggest competitive game of 2020 with a total prize pool of $14.75 mil."));
            em.persist(new Esport("Rocket League", "An up-and-coming esports game with famous teams such as F.C. Barcelona."));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public long getEsportCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long esportCount = (long)em.createQuery("SELECT COUNT(e) FROM Esport e").getSingleResult();
            return esportCount;
        }finally{
            em.close();
        }
    }
    
    public List<EsportDTO> getAllEsports() {
        EntityManager em = emf.createEntityManager();
        try {
            List<EsportDTO> list = em.createQuery("SELECT e FROM Esport e ORDER BY e.name ASC").getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    
//    public List<EsportDTO> getAllEsports() {
//        EntityManager em = emf.createEntityManager();
//    }
}
