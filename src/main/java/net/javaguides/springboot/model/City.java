package net.javaguides.springboot.model;
import jakarta.persistence.*;
import org.springframework.cache.annotation.CacheConfig;

@Entity
@Table(name = "cities")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightID;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "country_id")
    private long country_id;

    public City() {
    }

    public City(String city_name, Long country_id) {
        super();
    }

    public City(long flightID, String city_name, Long country_id) {
        this.flightID = flightID;
        this.city_name = city_name;
        this.country_id = country_id;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String cityName) {
        this.city_name = cityName;
    }

    public Long getCountryID() {
        return country_id;
    }

    public void setCountryID(Long country_id) {
        this.country_id = country_id;
    }
}
