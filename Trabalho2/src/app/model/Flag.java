package app.model;

public class Flag {

    protected String flag;


    public Flag(String flag) {
        this.flag = flag;
    }


    public String getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "Flag{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
