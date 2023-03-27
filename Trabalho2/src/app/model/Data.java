package app.model;

import app.structure.BST;

public class Data implements Comparable<Data> {

    public AreaCode areaCode;
    public AreaCodeM49 areaCodeM49;
    public Area area;
    public ItemCode itemCode;
    public ItemCodeCPC itemCodeCpc;
    public Item item;
    public ElementCode elementCode;
    public Element element;
    public YearCode yearCode;
    public Year year;
    public Unit unit;
    public Value value;
    public  Flag flag;
    public String description;
    public Integer dataID;

    public Data(AreaCode areaCode, AreaCodeM49 areaCodeM49, Area area, ItemCode itemCode, ItemCodeCPC itemCodeCpc, Item item, ElementCode elementCode, Element element, YearCode yearCode, Year year, Unit unit, Value value, Flag flag, String description, Integer dataID) {
        this.areaCode = areaCode;
        this.areaCodeM49 = areaCodeM49;
        this.area = area;
        this.itemCode = itemCode;
        this.itemCodeCpc = itemCodeCpc;
        this.item = item;
        this.elementCode = elementCode;
        this.element = element;
        this.yearCode = yearCode;
        this.year = year;
        this.unit = unit;
        this.value = value;
        this.flag = flag;
        this.description = description;
        this.dataID = dataID;
    }

    public AreaCode getAreaCode() {
        return areaCode;
    }

    public AreaCodeM49 getAreaCodeM49() {
        return areaCodeM49;
    }

    public Area getArea() {
        return area;
    }

    public ItemCode getItemCode() {
        return itemCode;
    }

    public ItemCodeCPC getItemCodeCpc() {
        return itemCodeCpc;
    }

    public Item getItem() {
        return item;
    }

    public ElementCode getElementCode() {
        return elementCode;
    }

    public Element getElement() {
        return element;
    }

    public YearCode getYearCode() {
        return yearCode;
    }

    public Year getYear() {
        return year;
    }

    public Unit getUnit() {
        return unit;
    }

    public Value getValue() {
        return value;
    }

    public Flag getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDataID() {
        return dataID;
    }

    @Override
    public int compareTo(Data o) {
        return this.getDataID()- o.getDataID();
    }

    @Override
    public String toString() {
        return "Data{" +
                "areaCode=" + areaCode +
                ", areaCodeM49='" + areaCodeM49 + '\'' +
                ", area='" + area + '\'' +
                ", itemCode=" + itemCode +
                ", itemCodeCpc='" + itemCodeCpc + '\'' +
                ", item='" + item + '\'' +
                ", elementCode=" + elementCode +
                ", element='" + element + '\'' +
                ", yearCode=" + yearCode +
                ", year=" + year +
                ", unit=" + unit +
                ", value=" + value +
                ", flag=" + flag +
                ", description='" + description + '\'' +
                '}';
    }



}