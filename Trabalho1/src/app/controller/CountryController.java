package app.controller;

import app.structure.Data;
import app.structure.FileReaderData;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * The Country controller is where a country given by the user is located in the .csv and will show the
 * pair of years and the absolute value, per fruit, of that country.
 */
public class CountryController {

    /**
     * Country map map.
     *
     * @param country the country given by the user
     * @return the map so that the UI can print it out
     */
    public LinkedHashMap<Data, Data> CountryMap(String country) {
        ArrayList<Data> dataArr;
        Set<Data> dataChosenCountry = new HashSet<>();
        LinkedHashMap<Data, Data> results = new LinkedHashMap<>();
        LinkedHashMap<Data, Data> resultsFinal = new LinkedHashMap<>();
        int valorAbs = 0;
        {
            try {
                dataArr = new FileReaderData().readData("C:\\Users\\andre\\Desktop\\isep\\2ºano\\Esinf\\Trabalho1\\src\\FAOSTAT_data_en_9-7-2022_BIG.csv");
                for (Data d : dataArr) {
                    if (d.getArea().getArea().equals(country)) {
                        dataChosenCountry.add(d);
                    }
                }
                if (dataChosenCountry.size() <= 0) {
                    return null;
                } else {
                    ArrayList<Data> dataChosenCountryArr = new ArrayList<>(dataChosenCountry);
                    dataChosenCountryArr.sort(new SortByYear());
                    ListIterator<Data> iterator = dataChosenCountryArr.listIterator();
                    Data dataIt1 = iterator.next();
                    Data dataIt2 = iterator.next();
                    while (iterator.hasNext()) {
                        if (dataIt1.getItem().getItem().equals(dataIt2.getItem().getItem())) {
                            if (dataIt2.getYear().getYear() - 1 == dataIt1.getYear().getYear()) {
                                results.put(dataIt1, dataIt2);
                                iterator.previous();
                                iterator.previous();
                                iterator.remove();
                                dataIt1 = iterator.next();
                                if (iterator.hasNext())
                                    dataIt2 = iterator.next();
                            }
                        } else {
                            dataIt1 = iterator.next();
                            dataIt2 = iterator.next();
                        }
                    }

                }

                for( Map.Entry<Data, Data> entry : results.entrySet() ){
                    //System.out.println( entry);
                    int valorAbsAux = Math.abs( entry.getValue().getValue().getValue() - entry.getKey().getValue().getValue());
                    if (valorAbs < valorAbsAux){
                        resultsFinal.put(entry.getKey(), entry.getValue());
                        valorAbs = valorAbsAux;
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        return resultsFinal;
    }

/**
 * The type Sort by year will sort the Array so it's in order by fruit and then by year.
 */
static class SortByYear implements Comparator<Data> {
    public int compare(Data a, Data b) {
        int year = a.getYear().getYear().compareTo(b.getYear().getYear());
        int item = a.getItem().getItem().compareTo(b.getItem().getItem());
        return (item == 0) ? year : item;
    }
}}


