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
    @NamedQuery(name = "EsportTeam.deleteAllRows", query = "DELETE from EsportTeam"),
    @NamedQuery(name = "EsportTeam.getAllRows", query = "SELECT e from EsportTeam e")
})
public class EsportTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private double pricePerYear;
    private int minAge;
    private int maxAge;
    
    @ManyToOne(cascade = { CascadeType.PERSIST })
    private Esport esport;
    
//    @ManyToOne(cascade = { CascadeType.PERSIST })
//    private Coach coach;
    
    public EsportTeam() {
    }
    
//    For adding just an esport team
    public EsportTeam(String teamName, double pricePerYear, int minAge, int maxAge) {
        this.teamName = teamName;
        this.pricePerYear = pricePerYear;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    
//    For adding an esport team with an existing esport
    public EsportTeam(String teamName, double pricePerYear, int minAge, int maxAge, Esport esport) {
        this.teamName = teamName;
        this.pricePerYear = pricePerYear;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.esport = esport;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getPricePerYear() {
        return pricePerYear;
    }

    public void setPricePerYear(double pricePerYear) {
        this.pricePerYear = pricePerYear;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public Esport getEsport() {
        return esport;
    }

    public void setEsport(Esport esport) {
        if (esport != null) {
            this.esport = esport;
        } else {
            this.esport = null;
        }
    }
    
    
}
