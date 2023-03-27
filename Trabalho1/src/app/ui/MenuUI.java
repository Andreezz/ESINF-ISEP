package app.ui;

import app.controller.CompareQByCountryAscController;
import app.controller.CountryController;
import app.controller.MinimalQuantityController;
import app.controller.SuperiorQuantityController;
import app.model.Item;
import app.model.Value;
import app.structure.Data;
import app.structure.FileReaderData;
import app.utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MenuUI implements Runnable {


    private final SuperiorQuantityController controller;
    private final MinimalQuantityController controller2;
    private final CompareQByCountryAscController controller3;
    private final CountryController controller4;
    private final FileReaderData controller5;
    String fruit;
    Integer value;
    String country;


    int option;


    public MenuUI() {

        controller = new SuperiorQuantityController();
        controller2 = new MinimalQuantityController();
        controller3 = new CompareQByCountryAscController();
        controller4 = new CountryController();
        controller5 = new FileReaderData();

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

            System.out.println("1-Maximum number of consecutive years in which there was an increase in the amount of fruit production!");
            System.out.println("2-See the minimum of countries necessary to achieve the maximum amount of production!");
            System.out.println("3- See List of countries with production of a fruit higher that a given production!");
            System.out.println("4- See the maximum absolute value of a pair of years in a chosen country");
            System.out.println("5- Load csv file");
            System.out.println("0-Exit!");
            option = Utils.readIntegerFromConsole("Please select the desired option: ");
            switch (option) {
                case 1:

                    fruit = Utils.readLineFromConsole("Please type the desired fruit: ");
                    ArrayList<Data> list = controller.getCountriesWithFruit(fruit);
                    System.out.println("\n\n");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println(controller.getSuperiorQuantity(list));
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("\n\n");
                    break;

                case 2:
                    value = Utils.readIntegerFromConsole("Please type the desire value: ");
                    System.out.println("\n\n");
                    System.out.println("-----------------------------------------------------------");
                    System.out.print("Countries necessary--> ");
                    System.out.println(controller2.minimalNumber(new Value(value)));
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("\n\n");
                    break;

                case 3:
                    Value Q = new Value(Utils.readIntegerFromConsole("Input the production"));
                    String F = (Utils.readLineFromConsole("Input the desired fruit"));
                    System.out.println("\n");
                    System.out.println("-----------------------------------------------------------");
                    controller3.cpyByFruit(Q, F);
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("\n\n");
                    break;

                case 4:
                    country = Utils.readLineFromConsole("Please type the country: ");
                    LinkedHashMap<Data, Data> results = controller4.CountryMap(country);
                    int size = results.entrySet().size();
                    Map.Entry<Data, Data> entry = results.entrySet().iterator().next();

                    for (int i = 0; i < size - 1; i++) {
                        results.remove(entry.getKey(), entry.getValue());
                        entry = results.entrySet().iterator().next();

                    }
                    entry = results.entrySet().iterator().next();
                    float valorAbs = entry.getValue().getValue().getValue() - entry.getKey().getValue().getValue();
                    System.out.printf("%d/%d,%15s,%15.2f\n\n\n\n", entry.getKey().getYear().getYear(), entry.getValue().getYear().getYear(), entry.getKey().getItem().getItem(), Math.abs(valorAbs));
                    break;

                case 5:
                    int option = Utils.readIntegerFromConsole("1- SMALL   2-BIG");
                    if (option == 1) {
                        System.out.println(controller5.readData("C:\\Users\\andre\\Desktop\\isep\\2ºano\\Esinf\\Trabalho1\\src\\FAOSTAT_data_en_9-7-2022_SMALL .csv"));

                    }
                    if (option == 2) {
                        System.out.println(controller5.readData("C:\\Users\\andre\\Desktop\\isep\\2ºano\\Esinf\\Trabalho1\\src\\FAOSTAT_data_en_9-7-2022_BIG.csv"));
                    }
                    break;

                default:
                    System.out.println("The application is closed!");
                    return false;


            }
        }
        while (option != -1);


        return true;


    }

}
