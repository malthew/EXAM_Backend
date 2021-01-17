
package dto;

/**
 *
 * @author Selina A.S.
 */

public class KanyeRestDTO {
    private final String quote;

    public KanyeRestDTO(String quote) {
        this.quote = quote;
    }
    
    public String getQuote() {
        return quote;
    }
    
    @Override
    public String toString() {
        return "KanyeWestDTO {" + "quote=" + quote + '}';
    }  
}
