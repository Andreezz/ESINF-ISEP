package app.model;

public class AreaCodeM49 extends Area{

    protected String areaCodeM49;

    public AreaCodeM49(String area, String areaCodeM49) {
        super(area);
        this.areaCodeM49 = areaCodeM49;
    }

    public String getAreaCodeM49() {
        return areaCodeM49;
    }

    public int compareTo(Data o) {
        return this.areaCodeM49.compareTo(o.getAreaCodeM49().getAreaCodeM49());
    }


    @Override
    public String toString() {
        return "AreaCodeM49{" +
                "areaCodeM49='" + areaCodeM49 + '\'' +
                '}';
    }
}
