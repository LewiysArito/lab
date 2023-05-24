package domain;

public class City extends Locality {
    private int naturalIncrease;
    private String isAdministrativeCenter;

    public City() {
    }

    public City(String[] line) {
        super(line[1], line[2], line[3], Integer.parseInt(line[4]));
        naturalIncrease = Integer.parseInt(line[5]);
        isAdministrativeCenter = line[6];
    }

    public int getNaturalIncrease() {return naturalIncrease;}

    public void setNaturalIncrease(int naturalIncrease) {this.naturalIncrease = naturalIncrease;}

    public String getIsAdministrativeCenter() {return isAdministrativeCenter;}

    public void setIsAdministrativeCenter(String isAdministrativeCenter) {this.isAdministrativeCenter = isAdministrativeCenter;}

    public String toString() {
        return "Город: " + super.toString() +
                " | Естественный прирост/убыль: " +
                naturalIncrease +
                " | Административный центр: " +
                isAdministrativeCenter;
    }
}
