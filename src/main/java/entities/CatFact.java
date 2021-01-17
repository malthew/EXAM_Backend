
package entities;

/**
 *
 * @author miade
 */
public class CatFact {
    
    private String id;
    private String type;
    private String user;
    private String text;
    private int version;
    private String createdAt;

    public CatFact(String id, String type, String user, String text, int version, String createdAt) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.text = text;
        this.version = version;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
