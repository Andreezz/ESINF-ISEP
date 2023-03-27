package app.model;

public class ElementCode extends Element {

    protected Integer elementCode;

    public ElementCode(String element, Integer elementCode) {
        super(element);
        this.elementCode = elementCode;
    }

    public Integer getElementCode() {
        return elementCode;
    }

    public int compareTo(Data o) {
        return this.elementCode.compareTo(o.getElementCode().getElementCode());
    }


    @Override
    public String toString() {
        return "ElementCode{" +
                "elementCode=" + elementCode +
                '}';
    }
}
