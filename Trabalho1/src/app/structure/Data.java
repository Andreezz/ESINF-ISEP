package app.structure;

import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.model.Year;

import java.util.Date;

public class Data implements Comparable<Data>{

    private String domainCoide;
    private String domain;
    private String areaCode;
    private Area area;
    private String elementCode;
    private String element;
    private String itemCode;
    private Item item;
    private String yearCode;
    private Year year;
    private String unit;
    private Value value;
    private String flag;
    private String description;

    public Data(String domainCoide, String domain, String areaCode, Area area, String elementCode, String element, String itemCode, Item item, String yearCode, Year year, String unit, Value value, String flag, String description) {
        this.domainCoide = domainCoide;
        this.domain = domain;
        this.areaCode = areaCode;
        this.area = area;
        this.elementCode = elementCode;
        this.element = element;
        this.itemCode = itemCode;
        this.item = item;
        this.yearCode = yearCode;
        this.year = year;
        this.unit = unit;
        this.value = value;
        this.flag = flag;
        this.description = description;
    }


    public String getDomainCoide() {
        return domainCoide;
    }

    public String getDomain() {
        return domain;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public Area getArea() {
        return area;
    }

    public String getElementCode() {
        return elementCode;
    }

    public String getElement() {
        return element;
    }

    public String getItemCode() {
        return itemCode;
    }

    public Item getItem() {
        return item;
    }

    public String getYearCode() {
        return yearCode;
    }

    public Year getYear() {
        return year;
    }

    public String getUnit() {
        return unit;
    }

    public Value getValue() {
        return value;
    }

    public String getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Data{" +
                "domainCoide='" + domainCoide + '\'' +
                ", domain='" + domain + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", area='" + area + '\'' +
                ", elementCode='" + elementCode + '\'' +
                ", element='" + element + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", item='" + item + '\'' +
                ", yearCode='" + yearCode + '\'' +
                ", year='" + year + '\'' +
                ", unit='" + unit + '\'' +
                ", Value='" + value + '\'' +
                ", flag='" + flag + '\'' +
                ", description='" + description + '\'' +
                '}' + "\n";

        }
    @Override
    public int compareTo(Data data){
        return this.getValue().compareTo(data.value);
    }
}
