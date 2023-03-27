package app.test;

import app.controller.NareaController;
import app.model.Area;
import app.model.Value;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NareaControllerTest {
    NareaController controller = new NareaController();

    Area area1 = new Area("Slovakia");
    Area area2 = new Area("Greece");
    Value value1 = new Value(48570.0);
    Value value2 = new Value(17580.0);

    int n = 1;
    @Test
    void narea() {
        Map<String, Double> testClass = new HashMap<>();
        testClass.put(String.valueOf(area1), value1.value);
        testClass.put(String.valueOf(area2), value2.value);
        Map<String, Double> result = new HashMap<>();
        result = controller.Narea(testClass, n);
        System.out.print("Result --> ");
        System.out.println(result);
        Map<String, Double> expected = new HashMap<>();
        expected.put(String.valueOf(area1), value1.value);
        System.out.print("Expected --> ");
        System.out.println(expected);
        assertEquals(expected, result);
    }
}