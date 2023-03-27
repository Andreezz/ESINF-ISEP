package app.model;

import java.util.Date;

public class Year {


    public Integer year;

    public Year(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                '}';
    }
}