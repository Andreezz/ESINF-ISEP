package app.ui;

import app.controller.AreaGeographicController;
import app.controller.FindAreaController;
import app.controller.NareaController;
import app.controller.YearEstimationController;
import app.model.Data;
import app.model.DataCoordinates;
import app.structure.BST;
import app.structure.FileReaderCoordinates;
import app.structure.FileReaderDataBST;
import app.structure.KDtree;
import app.utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuUI implements Runnable {


    private final AreaGeographicController controller;
    private final FileReaderDataBST fileReaderDataBST;
    private final FileReaderCoordinates fileReaderCoordinates;
    private final FindAreaController findAreaController;
    private final NareaController NareaController;
    private final YearEstimationController yearEstimationController;
    BST<Data> tree = new BST<>();
    KDtree<DataCoordinates> kdtree = new KDtree<>();


    int option;


    public MenuUI() {

        controller = new AreaGeographicController();
        fileReaderDataBST = new FileReaderDataBST();
        fileReaderCoordinates = new FileReaderCoordinates();
        findAreaController = new FindAreaController();
        NareaController = new NareaController();
        yearEstimationController = new YearEstimationController();

    }


    public void run() {
        boolean success = false;
        try {
            success = Menu();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        if (success) System.out.println("\nThe operation was successful.");

    }


    public boolean Menu() throws IOException, ParseException {

        do {

            System.out.println("1-Load csv file!");
            System.out.println("2-Load Coordinates file!");
            System.out.println("10-Create BST sub tree!");
            System.out.println("3-Top Nareas");
            System.out.println("4-àrea geografica proxima das coordenadas");
            System.out.println("5-Acumulado dos valores  de produção para uma área geográfica retangular dada por uma latitude inicial, latitude final, longitude inicial e longitude final ");
            System.out.println("6-Year estimation by desired country");
            System.out.println("0-Exit!");
            option = Utils.readIntegerFromConsole("Please select the desired option: ");
            switch (option) {
                case 1:
                    int option = Utils.readIntegerFromConsole("1- EU   2-FR  3-WORLD");
                    if(option == 1){
                        int option2 = Utils.readIntegerFromConsole("1- Large   2-Medium  3-Small");
                        if(option2==1){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_EU_shuffle_large.csv");
                            System.out.println(tree);
                        }
                        if(option2==2){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_EU_shuffle_medium.csv");
                            System.out.println(tree);
                        }
                        if(option2==3){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_EU_shuffle_small.csv");
                            System.out.println(tree);
                        }


                    }
                    if(option == 2){
                        int option2 = Utils.readIntegerFromConsole("1- Large   2-Medium  3-Small");
                        if(option2==1){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_large.csv");
                            System.out.println(tree);
                        }
                        if(option2==2){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_medium.csv");
                            System.out.println(tree);
                        }
                        if(option2==3){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_FR_GER_IT_PT_SP_shuffle_small.csv");
                            System.out.println(tree);
                        }}
                    if(option == 3){
                        int option2 = Utils.readIntegerFromConsole("1- Large   2-Medium  3-Small");
                        if(option2==1){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_World_shuffle_large.csv");
                            System.out.println(tree);
                        }
                        if(option2==2){

                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_World_shuffle_medium.csv");
                            System.out.println(tree);
                        }
                        if(option2==3){
                            tree = fileReaderDataBST.readBST("Production_Crops_Livestock_World_shuffle_small.csv");
                            System.out.println(tree);
                        }
                    }
                    break;


                case 2:
                    kdtree = fileReaderCoordinates.readCoordinates("Production_Crops_Livestock_E_AreaCoordinates_shuffled_v2.csv");
                    System.out.println(kdtree);
                    break;

                case 3:
                    String itemoo = Utils.readLineFromConsole("Please type the item");
                    String elementoo = Utils.readLineFromConsole("Please type the element");
                    BST<Data> bstTree =  NareaController.element_itensubtree(itemoo,elementoo,tree);
                    NareaController.year_narea(bstTree);
                    Map<String, Double> map = NareaController.year_narea(bstTree);
                    Integer n = Utils.readIntegerFromConsole("How many areas do you wish to see?");
                    NareaController.Narea(map,n);
                    System.out.println(NareaController.Narea(map,n));
                    break;



                case 4:

                    Double x = Utils.readDoubleFromConsole("Input Latitude");
                    Double y = Utils.readDoubleFromConsole("Input Longitude");
                    DataCoordinates dataCoordinates = findAreaController.findNode(kdtree, x, y);
                    System.out.println(dataCoordinates);
                    System.out.println(kdtree);
                    System.out.println(tree);
                    String element=Utils.readLineFromConsole("Input element");
                    String item=Utils.readLineFromConsole("Input item");
                    int year=Utils.readIntegerFromConsole("Input year");
                    System.out.println(findAreaController.findBST(tree, dataCoordinates, element, item, year));
                    break;

                case 5:


                    Double latI = Utils.readDoubleFromConsole("Please type the desired initial Latitude");
                    Double latF = Utils.readDoubleFromConsole("Please type the desired final Latitude");
                    Double longI = Utils.readDoubleFromConsole("Please type the desired initial Longitude");
                    Double longF = Utils.readDoubleFromConsole("Please type the desired final Longitude");
                    controller.GeographicValue(kdtree, latI, latF, longI, longF);
                    controller.bstSubTree(tree);
                    System.out.println("Please select how do you wish to search for the for the values");
                    int option3 = Utils.readIntegerFromConsole("1- Item Code   2-Element Code  3-Year Code");
                    if (option3 == 1) {
                        Integer itemCode = Utils.readIntegerFromConsole("Please type the desired Item Code");
                        controller.getSumValueItemCode(itemCode);

                    }

                    if (option3 == 2) {
                        Integer elementCode = Utils.readIntegerFromConsole("Please type the desired Element Code");
                        controller.getSumValueElementCode(elementCode);

                    }


                    if (option3 == 3) {
                        Integer yearCode = Utils.readIntegerFromConsole("Please type the desired Year Code");
                        controller.getSumValueYearCode(yearCode);


                    }

                    break;

                case 6:
                    String areaaa = Utils.readLineFromConsole("Please type the desired area:");
                    Integer year12 = Utils.readIntegerFromConsole("Please type the desired year1:");
                    Integer year13 = Utils.readIntegerFromConsole("Please type the desired year2:");
                    LinkedHashMap<Data,Double> results = yearEstimationController.yearEstimationController(tree,areaaa,year12,year13);
                    for (int i = 0; i < results.size(); i++) {
                        Map.Entry<Data, Double> entry = results.entrySet().iterator().next();
                        System.out.printf("%d...%d, %s, %s, %.2f\n", year12, year13, entry.getKey().getItem().getItem(), entry.getKey().getElement().getElement(), entry.getValue());
                        results.remove(entry.getKey(), entry.getValue());
                        if (results.entrySet().iterator().hasNext()){
                            results.entrySet().iterator().next();
                        }
                    }
                    break;


                case 10:
                    int option2 = Utils.readIntegerFromConsole("Please select the desired option: ");
                  if(option2==1){
                      String area = Utils.readLineFromConsole("Please type the desired Area");
                      System.out.println(fileReaderDataBST.areaSubtree(area,tree));
                  }

                    if(option2==2){
                        Integer area = Utils.readIntegerFromConsole("Please type the desired Area Code");
                        System.out.println(fileReaderDataBST.areaCodeSubtree(area,tree));
                    }

                    if(option2==3){
                        String elemento = Utils.readLineFromConsole("Please type the desired Element");
                        System.out.println(fileReaderDataBST.elementSubtree(elemento,tree));
                    }

                    if(option2==4){
                        Integer elementCode = Utils.readIntegerFromConsole("Please type the desired Element Code");
                        System.out.println(fileReaderDataBST.areaCodeSubtree(elementCode,tree));
                    }

                    if(option2==5){
                        String itemi = Utils.readLineFromConsole("Please type the desired Item");
                        System.out.println(fileReaderDataBST.itemSubtree(itemi,tree));
                    }

                    if(option2==6){
                        Integer itemCode = Utils.readIntegerFromConsole("Please type the desired Item Code");
                        System.out.println(fileReaderDataBST.areaCodeSubtree(itemCode,tree));
                    }
                    if(option2==7){
                        Integer yeari = Utils.readIntegerFromConsole("Please type the desired Year");
                        System.out.println(fileReaderDataBST.areaCodeSubtree(yeari,tree));
                    }


                default:
                    System.out.println("The application is closed!");
                    return false;


            }
        }
        while (option != -1);


        return true;


    }

}