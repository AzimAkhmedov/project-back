package net.javaguides.springboot.model;
import jakarta.persistence.*;
import org.springframework.cache.annotation.CacheConfig;

@Entity
@Table(name = "cities")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long city_id;

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "country_id")
    private long country_id;

    public City() {
    }

    public City(String city_name, Long country_id) {
        super();
    }

    public City(long city_id, String city_name, Long country_id) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.country_id = country_id;
    }

    public long getCity_id() {
        return city_id;
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
