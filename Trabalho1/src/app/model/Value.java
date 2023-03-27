package app.model;

import java.util.Comparator;

public class Value implements Comparable<Value>{

    public Integer value;

    public Value(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    /*public boolean compareTo(Value o){


        if(this.getValue() - o.getValue() < 0){

            return true;

        }
        else return false;

    }*/
    @Override
    public int compareTo(Value v1){
        if(v1 == null){
            v1=new Value(0);

        }
        return this.value.compareTo(v1.value);
    }


      /*public SeaDists compareTo(SeaDists o) {
        if(this.getSeaDistance()-o.getSeaDistance()>0){
            return o;
        }
        else return this;
    }*/
}
