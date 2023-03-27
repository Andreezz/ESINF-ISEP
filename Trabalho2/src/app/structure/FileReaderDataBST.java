package app.structure;

import app.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;
import java.util.Random;

import app.model.Data;
import app.structure.BST;
import app.utils.Utils;

public class FileReaderDataBST {


    String description;
    Data d1;
    BST<Data> bstTree = new BST<>();
    Integer dataID=0;


    /**
     * Reads the data from the csv and inserts it in the BST
     *
     * @param filename
     * @return BST<Data>
     * @throws IOException
     * @throws ParseException
     */

    public BST<Data> readBST(String filename) throws IOException, ParseException {
    FileReader readFile = new FileReader(filename);
    String line;
    BufferedReader bufferedReader = new BufferedReader(readFile);
    // discards the initial line
        bufferedReader.readLine();



        while ((line = bufferedReader.readLine()) != null) {

            if(line.contains("\"") ) { //BIG

              line = line.replace("\",\"", "|");
               line = line.replace("\"", "");
                line = line.replace(",,", "||");





           }

          else { //small
               line = line.replace(",", "|");


          }
          String [] info = line.split("\\|");


            if(Objects.equals(info[0],"")){
                info[0] = String.valueOf(0);
            }

            if(Objects.equals(info[1],"")){
                info[1] = String.valueOf(0);
            }
            if(Objects.equals(info[2],"")){
                info[2] = String.valueOf(0);
            }
            if(Objects.equals(info[3],"")){
                info[3] = String.valueOf(0);
            }
            if(Objects.equals(info[4],"")){
                info[4] = String.valueOf(0);
            }
            if(Objects.equals(info[5],"")){
                info[5] = String.valueOf(0);
            }
            if(Objects.equals(info[6],"")){
                info[6] = String.valueOf(0);
            }
            if(Objects.equals(info[7],"")){
                info[7] = String.valueOf(0);
            }
            if(Objects.equals(info[8],"")){
                info[8] = String.valueOf(0);
            }
            if(Objects.equals(info[9],"")){
                info[9] = String.valueOf(0);
            }
            if(Objects.equals(info[10],"")){
                info[10] = String.valueOf(0);
            }
            if(Objects.equals(info[11],"")){
                info[11] = String.valueOf(0.0);
            }

            if(Objects.equals(info[12],"")){
                info[12] = String.valueOf(0);
            }






      d1 = new Data((new AreaCode(info[2],Integer.parseInt(info[0]))),new AreaCodeM49(info[2],info[1]),new Area(info[2]), new ItemCode(info[5],Integer.parseInt(info[3])),new ItemCodeCPC(info[5],info[4]),new Item(info[5]),new ElementCode(info[7],Integer.parseInt(info[6]))
              ,new Element(info[7]),new YearCode(Integer.parseInt(info[9]),Integer.parseInt(info[8])),new Year(Integer.parseInt(info[9])),new Unit(info[10]),new Value(Double.parseDouble(info[11])),new Flag(info[12]),getDescription(info[12]),generateRandom(dataID));
             bstTree.insert(d1);


        }


        readFile.close();
        return bstTree;




}

    /**
     *
     * @param flag
     * @return String
     */
    public String getDescription(String flag){
        String description = "";

        if(flag.equals("A")){
            description = "Official figure";

        }
        if(flag.equals("E")){
            description = "Estimated value";

        }
        if(flag.equals("I")){
            description = "Imputed value";

        }
        if(flag.equals("M")){
            description = "Missing value (data cannot exist; not applicable)";

        }
        if(flag.equals("T")){
            description = "Unofficial figure";

        }
        return description;

    }


    /**
     * Generates random numbers for dataID
     *
     * @param dataID
     * @return Integet
     */
    public Integer generateRandom(Integer dataID){

        Random rand = new Random();
        dataID = rand.nextInt(10000000);
        return dataID;




    }

    /**
     * creates a subtree sorted by area
     *
     * @param area
     * @param mainTree
     * @return BST<Data>
     */
    public BST<Data> areaSubtree(String area, BST<Data> mainTree){

        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;

            if (area1.getArea().getArea().equals(area)) {

                subTree.insert(area1);

            }
        }
        return subTree;

    }

    /**
     * Creates a subtree sorted by areaCode
     *
     * @param areaCode
     * @param mainTree
     * @return BST<Data>
     */

    public BST<Data> areaCodeSubtree(Integer areaCode, BST<Data> mainTree){

        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;
            if (area1.getAreaCode().getAreaCode().equals(areaCode)) {
                subTree.insert(area1);


            }
        }
        return subTree;

    }


    /**
     * Creates a subtree sorted by element
     *
     * @param element
     * @param mainTree
     * @return BST<Data>
     */
    public BST<Data> elementSubtree(String element, BST<Data> mainTree){


        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;
            if (area1.getElement().getElement().equals(element)) {
                subTree.insert(area1);


            }
        }
        return subTree;

    }

    /**
     * Creates a subtree sorted by element code
     *
     * @param elementCode
     * @param mainTree
     * @return BST<Data>
     */
    public BST<Data> elementCodeSubtree(Integer elementCode, BST<Data> mainTree){


        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;
            if (area1.getElementCode().getElementCode().equals(elementCode)){
                subTree.insert(area1);


            }
        }
        return subTree;

    }

    /**
     * Creates a subtree sorted by item
     *
     * @param item
     * @param mainTree
     * @return BST<Data>
     */
    public BST<Data> itemSubtree(String item, BST<Data> mainTree){


        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;
            if (area1.getItem().getItem().equals(item)) {
                subTree.insert(area1);


            }
        }
        return subTree;

    }

    /**
     * Creates a subtree sorted by itemCode
     *
     * @param itemCode
     * @param mainTree
     * @return
     */

    public BST<Data> itemCodeSubtree(Integer itemCode, BST<Data> mainTree){


        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;
            if (area1.getItemCode().getItemCode().equals(itemCode)) {
                subTree.insert(area1);


            }
        }
        return subTree;

    }

    /**
     * Creates a subtree sorted by year
     *
     * @param year
     * @param mainTree
     * @return BST<Data>
     */

    public BST<Data> yearSubtree(Integer year, BST<Data> mainTree){


        BST<Data> subTree = new BST<>();

        for(Data area1 : mainTree.inOrder()) {
            // area1.area = area;
            if (area1.getYear().getYear().equals(year)) {
                subTree.insert(area1);


            }
        }
        return subTree;

    }


}



