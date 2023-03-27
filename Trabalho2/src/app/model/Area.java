package app.model;

public class Area {

    protected String area;

    public Area(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }



    public int compareTo(Data o) {
        return this.area.compareTo(o.getArea().getArea());
    }

    @Override
    public String toString() {
        return "Area{" +
                "area='" + area + '\'' +
                '}';
    }
}
