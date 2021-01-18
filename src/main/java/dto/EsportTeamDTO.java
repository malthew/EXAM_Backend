package dto;

import entities.Esport;
import entities.EsportTeam;

/**
 *
 * @author Malthe
 */
public class EsportTeamDTO {
    
    private long id;
    private String teamName;
    private double pricePerYear;
    private int minAge;
    private int maxAge;
    
    private Esport esport;
    
    public EsportTeamDTO() {
    }
    
    public EsportTeamDTO(EsportTeam e) {
        this.id = e.getId();
        this.teamName = e.getTeamName();
        this.pricePerYear = e.getPricePerYear();
        this.minAge = e.getMinAge();
        this.maxAge = e.getMaxAge();
        
        this.esport = e.getEsport();
    }
    
    public EsportTeamDTO(String teamName, double pricePerYear, int minAge, int maxAge, Esport esport) {
        this.teamName = teamName;
        this.pricePerYear = pricePerYear;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.esport = esport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        this.esport = esport;
    }
    
    
    
}
