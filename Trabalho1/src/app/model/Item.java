package app.model;

import java.util.Objects;

public class Item {


    protected String item;

    public Item(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                '}';
    }

    public String getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }
}
