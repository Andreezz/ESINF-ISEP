package app.controller;
import app.model.*;
import app.structure.BST;
import app.structure.KDtree;

import java.io.IOException;
import java.text.ParseException;

public class AreaGeographicController {


    public Value value;
    public Latitude latI;
    public Latitude latF;
    public Longitude longI;
    public Longitude longF;

    KDtree<DataCoordinates> kDtree = new KDtree();
    BST<Data> bstTree = new BST();
    DataCoordinates d1;
    KDtree<DataCoordinates> subTree = new KDtree<>();
    BST<Data> bstSubTree = new BST();

    public AreaGeographicController(){


    }

    public AreaGeographicController(Value value, Latitude latI, Latitude latF, Longitude longI, Longitude longF) {
        this.value = value;
        this.latI = latI;
        this.latF = latF;
        this.longI = longI;
        this.longF = longF;
    }


    /**
     * this function receives as parameter an KDtree and returs that same KDtree but sorted within the values introduced
     *
     * @param kDtree
     * @param latI
     * @param latF
     * @param longI
     * @param longF
     * @return KDtree<DataCoordinates>
     * @throws IOException
     */
    public KDtree<DataCoordinates> GeographicValue(KDtree<DataCoordinates> kDtree,Double latI, Double latF, Double longI, Double longF) throws IOException {

        for(DataCoordinates d1 : kDtree.inOrder()){
            if(latI<=d1.getLatitude().getLatitude() && longI<=d1.getLongitude().getLongitude())
                if(d1.getLatitude().getLatitude()<=latF && d1.getLongitude().getLongitude()<=longF){

                    subTree.insert(d1,d1.getLatitude().getLatitude(),d1.getLongitude().getLongitude());


                }
        }

        return subTree;

    }

    /**
     * this function receives as parameter an BST and returs that same BST but sorted by area
     *
     * @param bstTree
     * @return BST<Data>
     * @throws IOException
     * @throws ParseException
     */
    public BST<Data> bstSubTree(BST<Data> bstTree) throws IOException, ParseException {

        for(Data d1 : bstTree.inOrder()){
            for(DataCoordinates d2 : subTree.inOrder()){
                if(d1.getArea().getArea().equals(d2.getArea().getArea())){


                    bstSubTree.insert(d1);

                }  }

        }


        return bstSubTree;
    }

    /**
     * This function returns the value sorted by ItemCode
     *
     * @param itemCode
     * @return Double
     */
    public Double getSumValueItemCode(Integer itemCode){
        Double total=0.0;
        Double aux =0.0;

        for(Data d1 : bstSubTree.inOrder()){
            if(d1.getItemCode().getItemCode().equals(itemCode)){
                aux = d1.getValue().getValue();
                total = total + aux;
            }
        }
        System.out.println(total);
        return total;


    }

    /**
     * This function returns the value sorted by elementCode
     *
     * @param elementCode
     * @return Double
     */

    public Double getSumValueElementCode(Integer elementCode){

        Double total=0.0;
        Double aux =0.0;

        for(Data d1 : bstSubTree.inOrder()){
            if(d1.getElementCode().getElementCode().equals(elementCode)){
                System.out.println(d1.getValue().getValue());
                aux = d1.getValue().getValue();
                total = total + aux;
            }
        }
        System.out.println(total);
        return total;

    }

    /**
     * This function returns the value sorted by yearCode
     *
     * @param yearCode
     * @return Double
     */
    public Double getSumValueYearCode(Integer yearCode){
        Double total=0.0;
        Double aux =0.0;

        for(Data d1 : bstSubTree.inOrder()){
            if(d1.getYearCode().getYearcode().equals(yearCode)){
                System.out.println(d1.getValue().getValue());
                aux = d1.getValue().getValue();
                total = total + aux;
            }
        }
        System.out.println(total);
        return total;



    }


}
