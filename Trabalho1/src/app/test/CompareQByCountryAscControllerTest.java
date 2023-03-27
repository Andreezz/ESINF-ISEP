package app.test;

import app.controller.CompareQByCountryAscController;
import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.model.Year;
import app.structure.Data;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompareQByCountryAscControllerTest {
    CompareQByCountryAscController ascController=new CompareQByCountryAscController();

    Data d1=new Data("123","132","23", new Area("Spain"), "1","P", "99",new Item("Apples"), "2000",new Year(2000), "t", new Value(250),"", "o");
    Data d2=new Data("123","132","24", new Area("Portugal"), "1","P", "99",new Item("Apples"), "2001",new Year(2001), "t", new Value(240),"", "o");
    Data d3 = new Data("123","132","25", new Area("France"), "1","P", "99",new Item("Apples"), "1999",new Year(1999), "t", new Value(220),"", "o");

    Data d4= new Data("123","132","25", new Area("Spain"), "1","P", "99",new Item("Bananas"), "1999",new Year(1999), "t", new Value(260),"", "o");

    Data d5=new Data("123","132","25", new Area("Portugal"), "1","P", "99",new Item("Bananas"), "1999",new Year(1999), "t", new Value(220),"", "o");

    Data d6= new Data("123","132","25", new Area("France"), "1","P", "99",new Item("Apples"), "1999",new Year(2003), "t", new Value(229),"", "o");
    @Test
    void cpyByFruit() throws IOException, ParseException {
         ArrayList<Data> arrayList=new ArrayList<>();
         Value Q=new Value(230);
         arrayList.add(d1);
         arrayList.add(d2);
         arrayList.add(d3);
         arrayList.add(d4);
         arrayList.add(d5);
         arrayList.add(d6);
         String I=("Apples");
         ArrayList<Area> res= new ArrayList<>();
         res=ascController.cpyByFruit(Q,I);
         ArrayList<Area> exp=new ArrayList<>();
         Area a1=new Area("Portugal");
         Area a2= new Area("Spain");
         Area a4= new Area("Descending");
         exp.add(a1);
         exp.add(a2);
         exp.add(a4);
         exp.add(a2);
         exp.add(a1);
         assertEquals(exp,res);
     }
}