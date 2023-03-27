package app.structure;

import app.model.Area;
import app.model.Item;
import app.model.Value;
import app.model.Year;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class FileReaderData {


    Data data;


    /**
     *
     * @param filename
     * @return List<Data>
     * @throws IOException
     * @throws ParseException
     */

    public ArrayList<Data> readData(String filename) throws IOException, ParseException{

        FileReader readFile = new FileReader(filename);
        String line;
        BufferedReader bufferedReader = new BufferedReader(readFile);

        // discards the initial line
        bufferedReader.readLine();
        Scanner sc = new Scanner(System.in);


        ArrayList<Data>  dataList = new ArrayList<>();
        while ((line= bufferedReader.readLine()) != null) {


        //   String contents = (sc.nextLine());

           if(line.contains("\"")) { //BIG

               line = line.replace("\",\"", "|");
               line = line.replace("\"", "");
           }
           else { //small
               line = line.replace(",", "|");
           }
           String [] info = line.split("\\|");

           if(Objects.equals(info[11],"")){

               info[11] = String.valueOf(0);
           }

            Data d1 = new Data(info[0],info[1],info[2],new Area(info[3]),info[4],
                    info[5],info[6], new Item(info[7]),info[8], new Year(Integer.parseInt(info[9])), info[10],
                    new Value(Integer.parseInt(info[11])), info[12], info[13]);


           dataList.add(d1);



        }
       //sc.close();
        readFile.close();
        return dataList;
    }


}


