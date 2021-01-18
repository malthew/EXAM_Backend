package dto;

import entities.Esport;
import java.util.List;

/**
 *
 * @author Malthe
 */
public class EsportDTO {
    private String name;
    private String description;
    private List<EsportTeamDTO> esportTeams;
    
    //Constructor for making EsportDTOs with test data
    public EsportDTO(Esport esport) {
        this.name = esport.getName();
        this.description = esport.getDescription();
    }
    //Constructor for making EsportDTOs with data from a POST
    public EsportDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public EsportDTO() {
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

    public List<EsportTeamDTO> getEsportTeams() {
        return esportTeams;
    }

    public void setEsportTeams(List<EsportTeamDTO> esportTeams) {
        this.esportTeams = esportTeams;
    }

    @Override
    public String toString() {
        return "EsportDTO{" + "name=" + name + ", description=" + description + ", esportTeams=" + esportTeams + '}';
    }
    
    
}
