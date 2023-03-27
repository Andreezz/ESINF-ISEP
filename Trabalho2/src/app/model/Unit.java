package app.model;

public class Unit {
    protected String Unit;

    public Unit(String unit) {
        Unit = unit;
    }


    public String getUnit() {
        return Unit;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "Unit='" + Unit + '\'' +
                '}';
    }
}
