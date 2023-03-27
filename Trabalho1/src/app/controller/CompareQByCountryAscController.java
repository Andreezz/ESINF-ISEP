package app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.structure.Data;
import app.structure.FileReaderData;


public class CompareQByCountryAscController {

    public CompareQByCountryAscController() {

    }
   /* public ArrayList<Data> getCountriesWithFruit(String I)throws IOException, ParseException{

    }*/

    public ArrayList<Area> cpyByFruit(Value Q, String I) throws IOException, ParseException {
        ArrayList<Data> fileReaderData;
        fileReaderData = new FileReaderData().readData(
                "FAOSTAT_data_en_9-7-2022_SMALL.csv"
        );
        ListIterator<Data> it = fileReaderData.listIterator();
        ArrayList<Data> fruitArray = new ArrayList<>();
        /**
         * @ parameter fruitArray
         * @ parameter I (fruit)
         * this while adds from fileReaderData to fruitArray only the Data that has the same fruit as the one given by the user.
         */
        while (it.hasNext()) {
            Data data = it.next();
            if (data.getItem().getItem().equals(I)) {
                fruitArray.add(data);
            }
        }

        Iterator<Data> it1 = fruitArray.iterator();
        /**
         * @ parameter Q (production value)
         * @ parameter fruitArray
         * removes all the members of the array that are below the production value given by the user.
         */
        while (it1.hasNext()) {
            Data data = it1.next();
            if (data.getValue().compareTo(Q)==-1){
                it1.remove();
            }
        }
        //System.out.println(fruitArray);
        ListIterator<Data> it2 = fruitArray.listIterator();
        Value min = new Value(0);
        int m=0;
        Value maxArray[]=new Value[200];
        /**
         * @ parameter fruitArray
         * @ parameter min
         * searches through the array for the smallest value that is higher than Q, for each country, and adds it to maxArray.
         */
        while (it2.hasNext()) {
            Data data=it2.next();
            min=data.getValue();
            String area= data.getArea().getArea();
            while (data.getArea().getArea().equals(area)&&it2.hasNext()){
                if (data.getValue().compareTo(min)!=1){
                    min=data.getValue();
                    maxArray[m]=min;
                }
                data=it2.next();
                if (!data.getArea().getArea().equals(area)){
                    data=it2.previous();
                    break;}
            }
            //System.out.println(maxArray[m]);
            m++;
        }
        m=0;
        ListIterator<Data> it3=fruitArray.listIterator();
        /**
         * @ parameter maxArray
         * @ parameter fruitArray
         * iterates through the array list fruitArray and compares the members to the min in maxArray, diferent for every country, and removes the
         * members that have a higher value than the min.
         */
        while (it3.hasNext()){
            Data data=it3.next();
            String area=data.getArea().getArea();
            while (data.getArea().getArea().equals(area) &&it3.hasNext()){
                if (data.getValue().compareTo(maxArray[m])==1){
                    it3.remove();
                }
                data=it3.next();
                if (!data.getArea().getArea().equals(area)){
                    data=it3.previous();
                    break;
                }
            }
            m++;
        }
        it3.previous();
        it3.remove();
        ArrayList<Data> reverse= new ArrayList<>();
        int i;
        /**
         * Adds all the members in fruitArray to another ArrayList.
         */
        for (i=0; i<fruitArray.size(); i++){
            reverse.add(fruitArray.get(i));
        }
        Collections.sort(fruitArray); // Sorts the array in ascending form.
        Collections.sort(reverse,Collections.reverseOrder()); // sorts the array in descending form.
        ArrayList<Area> areaList=new ArrayList<>();
        Iterator<Data> it4= fruitArray.iterator();
        /**
         * Adds the array in ascending form to the array to be returned.
         */
        while (it4.hasNext()){
            Data data = it4.next();
            areaList.add(data.getArea());
        }
        Area serparator= new Area("Descending");
        areaList.add(serparator);// Adds a barrier between the array in ascending and the one in descending form.
        Iterator <Data> it5 = reverse.iterator();
        /**
         * Adds the descending array to the one that is to be returned.
         */
        while (it5.hasNext()){
            Data data = it5.next();
            areaList.add(data.getArea());
        }
        System.out.println(areaList); //prints the List of countries asked.
        return areaList;
    }
}
