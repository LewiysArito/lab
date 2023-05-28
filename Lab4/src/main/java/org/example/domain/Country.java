package org.example.domain;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Country {

    private int id;
    private String name;
    private String capital;
    private int square;

    private int population;

    private Set<Village> villages = new LinkedHashSet<>();
    private Set<City> cities = new LinkedHashSet<>();

    @Basic
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Basic
    @Column(name = "name")
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Basic
    @Column(name = "capital")
    public String getCapital() {return capital;}
    public void setCapital(String capital) {this.capital = capital;}

    @Basic
    @Column(name = "population")
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    @Basic
    @Column(name = "square")
    public int getSquare() {return square;}
    public void setSquare(int square) {this.square = square;}

    @OneToMany(mappedBy = "country")
    public Set<Village> getVillages() {return villages;}
    public void setVillages(Set<Village> villages) {this.villages = villages;}
    @OneToMany(mappedBy = "country")
    public Set<City> getCities() {return cities;}
    public void setCities(Set<City> cities) {this.cities = cities;}
}
