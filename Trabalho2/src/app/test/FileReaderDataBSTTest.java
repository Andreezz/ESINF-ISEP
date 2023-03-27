package app.test;

import app.model.*;
import app.structure.BST;
import app.structure.FileReaderDataBST;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderDataBSTTest {
    FileReaderDataBST fileReaderDataBST;
    public FileReaderDataBSTTest(){
        fileReaderDataBST = new FileReaderDataBST();
    }

    @Test
    void readBSTInvalidFile() {
        Throwable resultString = null;
        try {
            BST<Data> bst = fileReaderDataBST.readBST("teste.csv");
        } catch (Exception ex) {
            resultString = ex.getCause();
        }
        Throwable expectedString = null;

        assertEquals(expectedString, resultString);
    }

    @Test
    void testValidFile() throws IOException, ParseException {
        BST<Data> bst = fileReaderDataBST.readBST("Production_Crops_Livestock_EU_shuffle_small.csv");
        int expected = 67;
        int result= bst.root().getElement().getAreaCode().getAreaCode();

        assertEquals(expected,result);

    }


    @Test
    void areaCodeSubtree() {
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        Data d1 = new Data((new AreaCode("Portugal",60)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data d2 = new Data((new AreaCode("Portugal",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(d1);
        bst.insert(d2);
        bst2.insert(d1);
        BST<Data> bst3 = fileReaderDataBST.areaCodeSubtree(60,bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }

    @Test
    void elementSubtree() {
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        Data d1 = new Data((new AreaCode("Portugal",60)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data d2 = new Data((new AreaCode("Portugal",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento2"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(d1);
        bst.insert(d2);
        bst2.insert(d1);
        BST<Data> bst3 = fileReaderDataBST.elementSubtree("Elemento",bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }

    @Test
    void elementCodeSubtree() {
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        Data d1 = new Data((new AreaCode("Portugal",60)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data d2 = new Data((new AreaCode("Portugal",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",425)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(d1);
        bst.insert(d2);
        bst2.insert(d1);
        BST<Data> bst3 = fileReaderDataBST.elementCodeSubtree(423,bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }

    @Test
    void itemSubtree() {
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        Data d1 = new Data((new AreaCode("Portugal",60)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data d2 = new Data((new AreaCode("Portugal",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants2","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(d1);
        bst.insert(d2);
        bst2.insert(d1);
        BST<Data> bst3 = fileReaderDataBST.itemSubtree("Pants",bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }

    @Test
    void itemCodeSubtree() {
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        Data d1 = new Data((new AreaCode("Portugal",60)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data d2 = new Data((new AreaCode("Portugal",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",346),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(d1);
        bst.insert(d2);
        bst2.insert(d1);
        BST<Data> bst3 = fileReaderDataBST.itemCodeSubtree(345,bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }

    @Test
    void yearSubtree() {
        BST<Data> bst = new BST<>();
        BST<Data> bst2 = new BST<>();
        Data d1 = new Data((new AreaCode("Portugal",60)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1900),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        Data d2 = new Data((new AreaCode("Portugal",61)),new AreaCodeM49("Portugal","M45"),new Area("Portugal"), new ItemCode("Pants",345),new ItemCodeCPC("Pants","CP345"),new Item("Pants"),new ElementCode("Elemento",423)
                ,new Element("Elemento"),new YearCode(1900,1900),new Year(1901),new Unit("unidade"),new Value(50.0),new Flag("A"),"Descrição",0);
        bst.insert(d1);
        bst.insert(d2);
        bst2.insert(d1);
        BST<Data> bst3 = fileReaderDataBST.yearSubtree(1900,bst);
        String expected = bst2.toString();
        String result = bst3.toString();
        assertEquals(expected,result);

    }
}