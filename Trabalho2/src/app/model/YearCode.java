package app.model;

public class YearCode extends Year  {
    protected Integer yearcode;

    public YearCode(Integer year, Integer yearcode) {
        super(year);
        this.yearcode = yearcode;
    }

    public Integer getYearcode() {
        return yearcode;
    }


    @Override
    public String toString() {
        return "YearCode{" +
                "yearcode=" + yearcode +
                '}';
    }
}
