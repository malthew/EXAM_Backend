package entities;

/**
 *
 * @author Malthe
 */
// Currently, this entity class has no purpose as the weather page in the frontend
// project is made only using Javascript, HTML and the weather API. The only reason to
// to make this and the DTO class is to be able to create test-entities.

public class WeatherInfo {
    private String cityName;
    private String countryCode;
    private double temp;
    private int appTemp;

    public WeatherInfo(String cityName, String countryCode, double temp, int appTemp) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.temp = temp;
        this.appTemp = appTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getAppTemp() {
        return appTemp;
    }

    public void setAppTemp(int appTemp) {
        this.appTemp = appTemp;
    }
    
    
}
