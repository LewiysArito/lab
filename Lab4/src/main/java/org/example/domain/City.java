package org.example.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class City {
    private int id;
    private String name;
    private Country country;
    private int foundingDate;
    private int population;
    @Basic
    @Id
    @GeneratedValue
    @Column(name ="id")
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Basic
    @Column(name = "name")
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @ManyToOne(fetch = FetchType.LAZY) // объект с отношение многие к одному, который сразу загружается в память
    @JoinColumn(name = "country_id")
    public Country getCountry() {return country;}
    public void setCountry(Country country) {this.country = country;}

    @Basic
    @Column(name ="founding_date")
    public int getFoundingDate() {return foundingDate;}
    public void setFoundingDate(int foundingDate) {this.foundingDate = foundingDate;}

    @Basic
    @Column(name ="population")
    public int getPopulation() {return population;}
    public void setPopulation(int population) {this.population = population;}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        City city = (City) o;
//        return id == city.id && Objects.equals(name, city.name) && Objects.equals(population, city.population) && Objects.equals(foundingDate, city.foundingDate);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population, foundingDate);
    }
}
