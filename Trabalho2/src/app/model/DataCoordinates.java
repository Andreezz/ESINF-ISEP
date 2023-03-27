package app.model;

public class DataCoordinates implements Comparable<DataCoordinates> {
    public String country;
    public Latitude latitude;
    public Longitude longitude;
    public Area area;

    public DataCoordinates(String country,Latitude latitude, Longitude longitude, Area area) {
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.area = area;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public Longitude getLongitude() {
        return longitude;
    }

    public Area getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "DataCoordinates{" +
                "latitude=" + latitude.latitude +
                ", longitude=" + longitude.longitude +
                ", area=" + area.area +
                '}';
    }

    @Override
    public int compareTo(DataCoordinates o) {
        return 0;
    }
}
