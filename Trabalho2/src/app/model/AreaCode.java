package app.model;

public class AreaCode extends Area {

    protected Integer areaCode;

    public AreaCode(String area, Integer areaCode) {
        super(area);
        this.areaCode = areaCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }


    public int compareTo(Data o) {
        return this.areaCode.compareTo(o.getAreaCode().getAreaCode());
    }

    @Override
    public String toString() {
        return "AreaCode{" +
                "areaCode=" + areaCode +
                '}';
    }
}
