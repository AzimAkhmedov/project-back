package net.javaguides.springboot.model;
import jakarta.persistence.*;
import org.springframework.cache.annotation.CacheConfig;

@Entity
@Table(name = "cities")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightID;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "countryID")
    private Long countryID;

    public City() {
    }

    public City(String cityName, Long countryID) {
        super();
    }

    public City(long flightID, String cityName, Long countryID) {
        this.flightID = flightID;
        this.cityName = cityName;
        this.countryID = countryID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }
}
