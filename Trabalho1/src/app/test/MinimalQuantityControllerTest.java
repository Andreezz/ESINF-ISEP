package app.test;


import app.controller.MinimalQuantityController;
import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.model.Year;
import app.structure.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MinimalQuantityControllerTest
{

    MinimalQuantityController controller = new MinimalQuantityController();
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

    Value v1 = new Value(200);


    @Test
    void minimalNumber() throws IOException, ParseException {
        ArrayList<Data> testValue = new ArrayList<>();
        testValue.add(d1);
        testValue.add(d2);
        testValue.add(d3);
        testValue.add(d4);
        testValue.add(d5);
        Integer result;
        result = controller.minimalNumber(v1);
        Integer expected = 1;

        assertEquals(expected, result);

    }
}