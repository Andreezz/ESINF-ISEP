
package app.test;

import app.controller.AreaGeographicController;
import app.model.*;
import app.structure.BST;
import app.structure.FileReaderCoordinates;
import app.structure.FileReaderDataBST;
import app.structure.KDtree;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class AreaGeographicControllerTest {

    FileReaderDataBST fileReaderDataBST;
    FileReaderCoordinates fileReaderCoordinates;
    AreaGeographicController controller;


    public AreaGeographicControllerTest(){
        fileReaderDataBST = new FileReaderDataBST();
        fileReaderCoordinates = new FileReaderCoordinates();
        controller = new AreaGeographicController();

    }

    @Test
   public void geographicValue() throws IOException {
        KDtree<DataCoordinates> kDtree = new KDtree<>();
        KDtree<DataCoordinates> kDtree2 = new KDtree<>();
        DataCoordinates d1 = new DataCoordinates("Portugal",new Latitude(1.0),new Longitude(30.0),new Area("PT"));
        DataCoordinates d2 = new DataCoordinates("Portugal",new Latitude(50.0),new Longitude(70.0),new Area("PT"));
        kDtree.insert(d1);
        kDtree.insert(d2);
        kDtree2.insert(d1);
        kDtree = controller.GeographicValue(kDtree,0.0,40.0,10.0,40.0);
        String expected = kDtree2.toString();
        String result = kDtree.toString();
        assertEquals(expected,result);
    }

    @Test
    public void bstSubTree() throws IOException, ParseException {
        KDtree<DataCoordinates> kDtree = new KDtree<>();
        KDtree<DataCoordinates> kDtree2 = new KDtree<>();
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        BST<Data> bst3 = new BST<>();
        Data p1 = new Data((new AreaCode("PT",60)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data p2 = new Data((new AreaCode("Espanha",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(p1);
        bst.insert(p2);
        bst2.insert(p1);
        DataCoordinates d1 = new DataCoordinates("Portugal",new Latitude(1.0),new Longitude(30.0),new Area("PT"));
        DataCoordinates d2 = new DataCoordinates("Portugal",new Latitude(50.0),new Longitude(70.0),new Area("PT"));
        kDtree.insert(d1);
        kDtree.insert(d2);
        kDtree2.insert(d1);
        controller.GeographicValue(kDtree,0.0,40.0,10.0,40.0);
        bst3 = controller.bstSubTree(bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }

    @Test
    public void getSumValueItemCode() throws IOException, ParseException {
        KDtree<DataCoordinates> kDtree = new KDtree<>();
        BST<Data> bst = new BST<>();
        Data p1 = new Data((new AreaCode("PT",60)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data p2 = new Data((new AreaCode("PT",61)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",347),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(p1);
        bst.insert(p2);
        DataCoordinates d1 = new DataCoordinates("Portugal",new Latitude(1.0),new Longitude(30.0),new Area("PT"));
        DataCoordinates d2 = new DataCoordinates("Portugal",new Latitude(50.0),new Longitude(70.0),new Area("PT"));
        kDtree.insert(d1);
        kDtree.insert(d2);
        controller.GeographicValue(kDtree,0.0,40.0,10.0,40.0);
        controller.bstSubTree(bst);

        Double expected = 50.0;
        Double result = controller.getSumValueItemCode(345);
        assertEquals(expected,result);
    }

    @Test
    public void getSumValueElementCode() throws IOException, ParseException {
        KDtree<DataCoordinates> kDtree = new KDtree<>();
        BST<Data> bst = new BST<>();
        Data p1 = new Data((new AreaCode("PT",60)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data p2 = new Data((new AreaCode("PT",61)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",425)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(p1);
        bst.insert(p2);
        DataCoordinates d1 = new DataCoordinates("Portugal",new Latitude(1.0),new Longitude(30.0),new Area("PT"));
        DataCoordinates d2 = new DataCoordinates("Portugal",new Latitude(50.0),new Longitude(70.0),new Area("PT"));
        kDtree.insert(d1);
        kDtree.insert(d2);
        controller.GeographicValue(kDtree,0.0,40.0,10.0,40.0);
        controller.bstSubTree(bst);

        Double expected = 50.0;
        Double result = controller.getSumValueElementCode(423);
        assertEquals(expected,result);
    }

    @Test
    public void getSumValueYearCode() throws IOException, ParseException {
        KDtree<DataCoordinates> kDtree = new KDtree<>();
        BST<Data> bst = new BST<>();
        Data p1 = new Data((new AreaCode("PT",60)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data p2 = new Data((new AreaCode("PT",61)),new AreaCodeM49("Portugal","M45"),new Area("PT"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1901,1901),new Year(1901),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(p1);
        bst.insert(p2);
        DataCoordinates d1 = new DataCoordinates("Portugal",new Latitude(1.0),new Longitude(30.0),new Area("PT"));
        DataCoordinates d2 = new DataCoordinates("Portugal",new Latitude(50.0),new Longitude(70.0),new Area("PT"));
        kDtree.insert(d1);
        kDtree.insert(d2);
        controller.GeographicValue(kDtree,0.0,40.0,10.0,40.0);
        controller.bstSubTree(bst);

        Double expected = 50.0;
        Double result = controller.getSumValueYearCode(1900);
        assertEquals(expected,result);
    }
}
