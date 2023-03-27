package app.model;

public class ItemCodeCPC extends Item {

    protected String itemCodeCPC;


    public ItemCodeCPC(String item, String itemCodeCPC) {
        super(item);
        this.itemCodeCPC = itemCodeCPC;
    }

    public String getItemCodeCPC() {
        return itemCodeCPC;
    }
    public int compareTo(Data o) {
        return this.itemCodeCPC.compareTo(o.getItemCodeCpc().getItemCodeCPC());
    }


    @Override
    public String toString() {
        return "ItemCodeCPC{" +
                "itemCodeCPC='" + itemCodeCPC + '\'' +
                '}';
    }
}
