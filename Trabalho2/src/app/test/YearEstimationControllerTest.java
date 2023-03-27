package app.test;

import app.controller.YearEstimationController;
import app.model.*;
import app.structure.BST;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YearEstimationControllerTest {

    YearEstimationController yearEstimationController = new YearEstimationController();

    @Test
    void yearEstimationControllerShouldReturnLinkedHashMapWithAverageOfEachItemInGivenAreaAndYears() {
        BST<Data> bst = new BST<>();
        Data p1 = new Data((new AreaCode("PT",60)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data p2 = new Data((new AreaCode("PT",61)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",425)
                ,new Element("Elemento"),new YearCode(1901,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(p1);
        bst.insert(p2);

        Set<Data> expectedSet = yearEstimationController.dataRestricted(bst, "PT", 1900, 1902);

        assertEquals(
                (Double) 50.0,
                yearEstimationController
                        .yearEstimationController(bst, "PT", 1900, 1902)
                        .get(expectedSet.iterator().next()));
    }

    @Test
    void dataRestrictedWhenBSTIsNotEmptyThenReturnEmptySet() {
        BST<Data> bst = new BST<>();
        Data p1 = new Data((new AreaCode("PT", 60)), new AreaCodeM49("Portugal", "M45"), new Area("PT"), new ItemCode("Pants", 345), new ItemCodeCPC("Pants", "CP345"), new Item("Pants"), new ElementCode("Elemento", 423)
                , new Element("Elemento"), new YearCode(1900, 1900), new Year(1900), new Unit("unidade"), new Value(50.0), new Flag("A"), "Descrição", 0);
        Data p2 = new Data((new AreaCode("PT", 61)), new AreaCodeM49("Portugal", "M45"), new Area("PT"), new ItemCode("Pants", 345), new ItemCodeCPC("Pants", "CP345"), new Item("Pants"), new ElementCode("Elemento", 425)
                , new Element("Elemento"), new YearCode(1900, 1900), new Year(1900), new Unit("unidade"), new Value(50.0), new Flag("A"), "Descrição", 0);
        bst.insert(p1);
        bst.insert(p2);
        Set<Data> dataRestricted = yearEstimationController.dataRestricted(bst, "", 0, 0);
        assertTrue(dataRestricted.isEmpty());
    }

    @Test
    void dataRestrictedWhenBSTHasOneElementAndItMatchesTheAreaAndYearThenReturnSetWithOneElement() {
        BST<Data> bst = new BST<>();
        Data data = new Data((new AreaCode("PT", 60)), new AreaCodeM49("Portugal", "M45"), new Area("PT"), new ItemCode("Pants", 345), new ItemCodeCPC("Pants", "CP345"), new Item("Pants"), new ElementCode("Elemento", 423)
                , new Element("Elemento"), new YearCode(1900, 1900), new Year(1900), new Unit("unidade"), new Value(50.0), new Flag("A"), "Descrição", 0);
        bst.insert(data);
        Set<Data> expected = new HashSet<>();
        expected.add(data);
        Set<Data> actual = yearEstimationController.dataRestricted(bst, "PT", 1899, 1901);
        assertEquals(expected, actual);
    }
}