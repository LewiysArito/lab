package domain;

public abstract class Locality implements LocalityWorld {
    private String localityName;
    private String country;
    private String foundingDate;
    private int population;

    public Locality() {
    }

    public Locality(String localityName, String country, String foundingDate, int population) {
        this.localityName = localityName;
        this.country = country;
        this.foundingDate = foundingDate;
        this.population = population;
    }

    public Locality(String[] line) {
        this.localityName = line[1];
        this.country = line[2];
        this.foundingDate = line[3];
        this.population = Integer.parseInt(line[4]);
    }

    public String getLocalityName() {
        return localityName;
    }

    public String getCountry() {
        return country;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public int getPopulation() {
        return population;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Название города: " +
                localityName +
                " | Страна: " +
                country +
                " | Дата основания: " +
                foundingDate +
                " | Численность населения: " +
                population;
    }
}
