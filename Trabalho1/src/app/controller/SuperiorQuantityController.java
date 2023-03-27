
package app.controller;

import app.structure.Data;
import app.structure.FileReaderData;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class SuperiorQuantityController {


    public SuperiorQuantityController() {

    }


    ArrayList<Data> fileReaderData;
    ArrayList<Data> countriesWithFruit = new ArrayList<>();
    //Map<String, Integer> countriesWithFruit = new HashMap<String, Integer>();

    /**
     *
     * @param fruto
     * @return List <Data>
     */
    public ArrayList<Data> getCountriesWithFruit(String fruto) {

        try {
            fileReaderData = new FileReaderData().readData("C:\\Users\\andre\\Desktop\\isep\\2ºano\\Esinf\\Trabalho1\\src\\FAOSTAT_data_en_9-7-2022_BIG.csv");

            //fileReaderData = new FileReaderData().readData("/Users/joaogomes/Desktop/ISEP/ESINF/Trabalho_ESINF/FAOSTAT_data_9-7-2022/FAOSTAT_data_en_9-7-2022_BIG.csv");

            for (Data f : fileReaderData) {
                if (f.getItem().getItem().equals(fruto)) {


                    countriesWithFruit.add(f);


                }
            }
            // System.out.println(countriesWithFruit.toString());


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return countriesWithFruit;

    }

    /**
     *
     * @param countryList
     * @return Map<String,Integer>
     */
    public Map<String,Integer> getSuperiorQuantity(ArrayList<Data> countryList){

        String paisAnterior = "";
        int valormaior = 0;
        int count = 0;
        int countMaior = 0;
        Map<String, Integer> CountriesWithFruit = new HashMap<>();



        for (Data g : countryList) {

            if(!g.getArea().getArea().equals(paisAnterior)){
                countMaior = 0;}
            if (g.getArea().getArea().equals(paisAnterior) )  {
                if (g.getValue().getValue() <= valormaior) {
                    count = 0;
                    valormaior = 0;
                  
                } else
                    valormaior = g.getValue().getValue();
                count++;
                if (count > countMaior) {
                    countMaior = count;
                    if (CountriesWithFruit.containsKey(g.getArea().getArea())) {
                        CountriesWithFruit.replace(g.getArea().getArea(), countMaior);
                    } else if (!CountriesWithFruit.containsKey(g.getArea().getArea())) {
                        CountriesWithFruit.put(g.getArea().getArea(), countMaior);
                    }
                }

            }
            paisAnterior = g.getArea().getArea();


        }



        return CountriesWithFruit;

    }

}




