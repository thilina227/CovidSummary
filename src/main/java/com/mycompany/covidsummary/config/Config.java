package com.mycompany.covidsummary.config;

/**
 * Singleton Config class to hold the configuration values
 */
public class Config {
    
    private String url;
    private String countryCode;
    
    private static Config instance;
    
    private Config() {
        //TODO Read from a text file
        this.url = "https://api.coronatracker.com/v3/stats/worldometer/country?countryCode=";
        this.countryCode = "LK";
    }
    
    public static Config getInstance(){
        if (instance == null) {
            instance = new Config();
        }
        
        return instance;
    }
    
    public String getUrl() {
        return url;
    }    
    
    public String getCountryCode() {
        return countryCode;
    }
}
