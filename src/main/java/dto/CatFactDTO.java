
package dto;

import entities.CatFact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miade
 */
public class CatFactDTO {
    
    private String id;
    private String text;
    private String createdAt;
    
    private List<CatFactDTO> catFactList;
    

    public CatFactDTO() {}

    public CatFactDTO(CatFact catFact) {
        this.id = catFact.getId();
        this.text = catFact.getText();
        this.createdAt = catFact.getCreatedAt();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<CatFactDTO> getCatFactList() {
        return catFactList;
    }

    public void addCatFactToList(CatFactDTO catFact) {
        this.catFactList.add(catFact);
    }

    
    
    
}
