package app.model;

public class Element {

    protected String element;

    public Element(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public int compareTo(Data o) {
        return this.element.compareTo(o.getElement().getElement());
    }


    @Override
    public String toString() {
        return "Element{" +
                "element='" + element + '\'' +
                '}';
    }
}
