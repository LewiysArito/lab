package domain;

public class Village extends Locality {
    private String involvedRuralization;
    private String locationArea;

    public Village() {
    }

    public Village(String[] line) {
        super(line[1], line[2], line[3], Integer.parseInt(line[4]));
        involvedRuralization = line[5];
        locationArea = line[6];
    }

    public String getInvolvedRuralization() {
        return involvedRuralization;
    }

    public void setInvolvedRuralization(String involvedRuralization) {
        this.involvedRuralization = involvedRuralization;
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea;
    }

    public String toString() {
        return "Село: " + super.toString() +
                " | Присутсвтует рураризация: " +
                involvedRuralization +
                " | Субъект нахождения: " +
                locationArea;
    }
}
