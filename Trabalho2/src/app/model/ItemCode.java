package app.model;

public class ItemCode extends Item {

    protected Integer itemCode;

    public ItemCode(String item, Integer itemCode) {
        super(item);
        this.itemCode = itemCode;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public int compareTo(Data o) {
        return this.itemCode.compareTo(o.getItemCode().getItemCode());
    }


    @Override
    public String toString() {
        return "ItemCode{" +
                "itemCode=" + itemCode +
                '}';
    }
}
