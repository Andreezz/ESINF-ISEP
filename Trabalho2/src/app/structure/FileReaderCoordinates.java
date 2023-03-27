package app.structure;

import app.model.Area;
import app.model.DataCoordinates;
import app.model.Latitude;
import app.model.Longitude;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileReaderCoordinates {

DataCoordinates dataCoordinates;
KDtree coordinatesKDtree = new KDtree<>();

    /**
     * this function reads the csv and inserts in the kdtree
     *
     * @param filename
     * @return KDtree
     * @throws IOException
     */
    public KDtree readCoordinates(String filename) throws IOException {

        FileReader readFile = new FileReader(filename);
        String line;
        Double x;
        Double y;
        BufferedReader bufferedReader = new BufferedReader(readFile);
        // discards the initial line
        bufferedReader.readLine();



        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");

            //x= Double.parseDouble(info[1]);
           // y=Double.parseDouble(info[2]);
            //Point2D.Double p=new Point2D.Double(x,y);
           dataCoordinates = new DataCoordinates(info[0],new Latitude(Double.parseDouble(info[1])),new Longitude(Double.parseDouble(info[2])),new Area(info[3]));
           coordinatesKDtree.insert(dataCoordinates,Double.parseDouble(info[1]),Double.parseDouble(info[2]));


        }
        readFile.close();

        



       return coordinatesKDtree;
    }



}
