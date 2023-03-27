package app.model;

import java.util.Objects;

public class Area {

    protected String area;

    public Area(String area)
    {
        this.area = area;
    }

    @Override
    public String toString()
    {
        return  area + "\n" ;
    }

    public String getArea()
    {
        return area;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}