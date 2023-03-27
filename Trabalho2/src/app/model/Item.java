package app.model;

public class Item {

    protected String item;


    public Item(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }


    public int compareTo(Data o) {
        return this.item.compareTo(o.getItem().getItem());
    }


    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                '}';
    }
}
