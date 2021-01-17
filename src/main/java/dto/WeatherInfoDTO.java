package dto;

import java.util.List;

/**
 *
 * @author Malthe
 */
// Currently, this DTO class has no purpose as the weather page in the frontend
// project is made only using Javascript, HTML and the weather API. The only reason to
// to make this and the entity class is to be able to create test-entities.

public class WeatherInfoDTO {
    private String cityName;
    private String countryCode;
    private double temp;
    private int appTemp;
    
    private List<WeatherInfoDTO> weatherInfoList;

    public WeatherInfoDTO(String cityName, String countryCode, double temp, int appTemp) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.temp = temp;
        this.appTemp = appTemp;
    }
    
    public WeatherInfoDTO() {
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

    public List<WeatherInfoDTO> getWeatherInfoList() {
        return weatherInfoList;
    }

    public void addWeatherInfoToList(WeatherInfoDTO weatherInfo) {
        this.weatherInfoList.add(weatherInfo);
    }
    
    
    
}
