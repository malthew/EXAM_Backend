package facades;

import dto.CourseDTO;
import errorhandling.AlreadyExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Malthe
 */
public class CourseFacadeTest {
    
    private static EntityManagerFactory emf;
    private static CourseFacade facade;
    private static SchoolClassFacade FACADE;
    private EntityManager em;
    
    
    public CourseFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = CourseFacade.getFacadeExample(emf);
       FACADE = SchoolClassFacade.getFacadeExample(emf);
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test        
    }
    
    @BeforeEach
    public void setUp() {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run        
    }
    
    @Test
    public void testAddCourse() throws AlreadyExistsException {
        CourseDTO coursedto = new CourseDTO("Test course 1", "Test description 1");
        CourseDTO cDTO = facade.addCourse(coursedto);
        assertThat(cDTO, is (coursedto));
    }
}
