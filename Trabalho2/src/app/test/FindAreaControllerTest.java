package app.test;

import app.controller.FindAreaController;
import app.model.*;
import app.structure.BST;
import app.structure.KDtree;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class FindAreaControllerTest {
    FindAreaController findAreaController = new FindAreaController();
    DataCoordinates d1 = new DataCoordinates("MQ", new Latitude(14.641528), new Longitude(-61.024174), new Area("Martinique"));
    DataCoordinates d2 = new DataCoordinates("HN", new Latitude(15.199999), new Longitude(-86.241905), new Area("Honduras"));
    DataCoordinates d3 = new DataCoordinates("TH", new Latitude(15.870032), new Longitude(-100.992541), new Area("Thailand"));
    DataCoordinates d4 = new DataCoordinates("NL", new Latitude(52.132633), new Longitude(-5.291266), new Area("Netherlands"));
    DataCoordinates d5 = new DataCoordinates("CY", new Latitude(35.126413), new Longitude(-33.429859), new Area("Cyprus"));
    DataCoordinates d6 = new DataCoordinates("AI", new Latitude(18.220554), new Longitude(-63.068615), new Area("Anguilla"));
    DataCoordinates d7 = new DataCoordinates("SL", new Latitude(8.460555), new Longitude(-11.779889), new Area("Sierra Leone"));

    Data d8=new Data(new AreaCode("Portugal",9),new AreaCodeM49("Portugal","pt"),new Area("Portugal"), new ItemCode("Carrots",81),new ItemCodeCPC("Carrots","cr"),new Item("Carrots"),new ElementCode("Yield",91)
            ,new Element("Yield"),new YearCode(2000,2000),new Year(2000),new Unit("E"),new Value(10.2),new Flag("Ent"),"ente",50);

    Data d9=new Data(new AreaCode("Thailand",56),new AreaCodeM49("Thailand","tl"),new Area("Thailand"), new ItemCode("Carrots",81),new ItemCodeCPC("Carrots","cr"),new Item("Carrots"),new ElementCode("Yield",91)
            ,new Element("Yield"),new YearCode(2003,2003),new Year(2003),new Unit("E"),new Value(70.65),new Flag("Enet"),"entp",70);

    Data d10=new Data(new AreaCode("Thailand",56),new AreaCodeM49("Thailand","tl"),new Area("Thailand"), new ItemCode("Carrots",81),new ItemCodeCPC("Carrots","cr"),new Item("Carrots"),new ElementCode("Yield",91)
            ,new Element("Yield"),new YearCode(1999,1999),new Year(1999),new Unit("E"),new Value(85.2),new Flag("Enert"),"enetp",85);

    Data d11=new Data(new AreaCode("Thailand",56),new AreaCodeM49("Thailand","tl"),new Area("Thailand"), new ItemCode("Apples",82),new ItemCodeCPC("Apples","app"),new Item("Apples"),new ElementCode("Production",95)
            ,new Element("Production"),new YearCode(2003,2003),new Year(2003),new Unit("E"),new Value(75.65),new Flag("Eneoqt"),"enwtp",20);

    Data d12=new Data(new AreaCode("Spain",63),new AreaCodeM49("Spain","sp"),new Area("Spain"), new ItemCode("Apples",82),new ItemCodeCPC("Apples","app"),new Item("Apples"),new ElementCode("Production",95)
            ,new Element("Production"),new YearCode(2003,2003),new Year(2003),new Unit("E"),new Value(780.65),new Flag("Enpeqt"),"enwtp",63);


    @Test
    void findNode()throws IOException, ParseException{
        KDtree<DataCoordinates> kDtree=new KDtree<>();
        kDtree.insert(d1,14.641528, -61.024174);
        kDtree.insert(d2,15.199999,-86.241905);
        kDtree.insert(d3,15.870032,-100.992541);
        kDtree.insert(d4,52.132633,-5.291266);
        kDtree.insert(d5,35.126413,-33.429859);
        kDtree.insert(d6,18.220554,-63.068615);
        kDtree.insert(d7,8.460555,-11.779889);
        Double x=15.6;
        Double y=-95.0;
        DataCoordinates res= findAreaController.findNode(kDtree,x,y);
        DataCoordinates exp=d3;
        assertEquals(exp,res);
    }

    @Test
    void findBST()throws IOException, ParseException{
        BST<Data> tree=new BST<>();
        DataCoordinates coordinates=new DataCoordinates("TH", new Latitude(15.870032), new Longitude(-100.992541), new Area("Thailand"));
        tree.insert(d8);
        tree.insert(d9);
        tree.insert(d10);
        tree.insert(d11);
        tree.insert(d12);
        String element="Yield";
        String item="Carrots";
        int year=1999;
        Data res= findAreaController.findBST(tree,coordinates,element,item,year);
        Data exp=d10;
        assertEquals(exp,res);

    }

}