package facades;

import entities.XXX;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class XXXFacade {

    private static XXXFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private XXXFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static XXXFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new XXXFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getXXXCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long XXXCount = (long)em.createQuery("SELECT COUNT(x) FROM XXX x").getSingleResult();
            return XXXCount;
        }finally{  
            em.close();
        }
        
    }

}
