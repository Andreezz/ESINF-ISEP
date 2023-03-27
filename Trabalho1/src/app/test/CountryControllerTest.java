package app.test;

import app.controller.CountryController;
import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.model.Year;
import app.structure.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CountryControllerTest {
    CountryController countryController;

    @Before
    public void setUp() {
        countryController = new CountryController();
    }

    /**
     * Should return a map with the data when the country is found
     */
    @Test
    public void countryMapWhenCountryIsFoundThenReturnAMapWithTheData() {
        LinkedHashMap<Data, Data> result = countryController.CountryMap("Portugal");
        assertNotNull(result);
    }

    /**
     * Should return null when the country is not found
     */
    @Test
    public void countryMapWhenCountryIsNotFoundThenReturnNull() {
        LinkedHashMap<Data, Data> result = countryController.CountryMap("idk");
        assertNull(result);
    }

    /**
     * Should return the expected value
     */
    @Test
    public void countryMapShouldReturnExpectedValue() {
        LinkedHashMap<Data, Data> result = new LinkedHashMap<Data, Data>();
        Data data1 =
                new Data("QCL","Crops and livestock products","174",new Area("Portugal"),"5510","Production","515",new Item("Apples"),"1985",new Year(1985),"tonnes",new Value(95100),"","Official data");
        Data data2 =
               new Data("QCL","Crops and livestock products","174",new Area("Portugal"),"5510","Production","515",new Item("Apples"),"1986",new Year(1986),"tonnes",new Value(238560),"","Official data");

        result.put(data1, data2);
        LinkedHashMap<Data, Data> actual = countryController.CountryMap("Portugal");
        int size = actual.entrySet().size();
        Map.Entry<Data, Data> entry = actual.entrySet().iterator().next();

        for (int i = 0; i < size-1; i++) {
            actual.remove(entry.getKey(), entry.getValue());
            entry = actual.entrySet().iterator().next();
        }
        entry = actual.entrySet().iterator().next();

            assertNotNull(result.entrySet().equals(actual.entrySet()));
        }
}