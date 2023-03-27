package app.test;

import app.controller.SuperiorQuantityController;
import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.model.Year;
import app.structure.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SuperiorQuantityControllerTest {


    SuperiorQuantityController controller = new SuperiorQuantityController();
    Data d1 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000", new Value(1), "123", "description");
    Data d2 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000", new Value(2), "123", "description");
    Data d3 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "10000000", new Value(3), "123", "description");
    Data d4 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "5", new Value(4), "123", "description");
    Data d5 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "1", new Value(7), "123", "description");
    Data d6 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "1", new Value(6), "123", "description");
    Data d7 = new Data("123", "123", "12345", new Area("Lisboa"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "10", new Value(5), "123", "description");
    Data d8 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "1000000000000000", new Value(10), "123", "description");
    Data d9 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000000000000000000", new Value(20), "123", "description");
    Data d10 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000000000000000000", new Value(20), "123", "description");
    Data d11 = new Data("123", "123", "12345", new Area("Porto"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000000000000000000", new Value(10), "123", "description");
   Data  d12 = new Data("123", "123", "12345", new Area("Lisboa"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000000000000000000", new Value(10), "123", "description");
   Data  d13 = new Data("123", "123", "12345", new Area("Lisboa"), "12345", "element"
            , "12345", new Item("apples"), "2002", new Year(2002), "100000000000000000000", new Value(15), "123", "description");



    @Test
    void getSuperiorQuantity() {
        ArrayList<Data> testFruit = new ArrayList<>();
        testFruit.add(d1);
        testFruit.add(d2);
        testFruit.add(d3);
        testFruit.add(d8);
        testFruit.add(d9);
        Map<String, Integer> result = new HashMap<>();
        result = controller.getSuperiorQuantity(testFruit);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Porto", 4);
        assertEquals(expected, result);


    }

    @Test
    void getSuperiorQuantityTwoCountries() {
        ArrayList<Data> testFruit = new ArrayList<>();
        testFruit.add(d7);
        testFruit.add(d12);
        testFruit.add(d13);
        testFruit.add(d1);
        testFruit.add(d2);
        testFruit.add(d3);
        testFruit.add(d8);
        testFruit.add(d9);
        Map<String, Integer> result = new HashMap<>();
        result = controller.getSuperiorQuantity(testFruit);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Porto", 4);
        expected.put("Lisboa",2);
        assertEquals(expected, result);


    }

    @Test
    void getSuperiorQuantityMixedCountriesAndValues() {
        ArrayList<Data> testFruit = new ArrayList<>();

        testFruit.add(d1);
        testFruit.add(d2);
        testFruit.add(d7);
        testFruit.add(d12);
        testFruit.add(d3);
        testFruit.add(d13);
        testFruit.add(d8);
        testFruit.add(d9);
        Map<String, Integer> result = new HashMap<>();
        result = controller.getSuperiorQuantity(testFruit);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Porto", 3);
        expected.put("Lisboa",2);
        assertEquals(expected, result);


    }


    @Test
    void getSuperiorQuantityNullList() {
        ArrayList<Data> testFruit = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();
        result = controller.getSuperiorQuantity(testFruit);
        Map<String, Integer> expected = new HashMap<>();
        assertEquals(expected, result);


    }

    @Test
    void getSuperiorQuantityNoSuperiorQuantity() {
        ArrayList<Data> testFruit = new ArrayList<>();
        testFruit.add(d10);
        testFruit.add(d11);
        testFruit.add(d1);

        Map<String, Integer> result = new HashMap<>();
        result = controller.getSuperiorQuantity(testFruit);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Porto", 1);
        assertEquals(expected, result);


    }

    @Test
    void getSuperiorQuantityDifferentArea() {
        ArrayList<Data> testFruit = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testFruit.add(d6);
            testFruit.add(d7);

        }
        Map<String, Integer> result = new HashMap<>();
        result = controller.getSuperiorQuantity(testFruit);
        Map<String, Integer> expected = new HashMap<>();
        assertEquals(expected, result);


    }
}