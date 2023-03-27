package app.test;

import app.model.DataCoordinates;
import app.structure.FileReaderCoordinates;
import app.structure.KDtree;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderCoordinatesTest {

    FileReaderCoordinates fileReaderCoordinates;
    public FileReaderCoordinatesTest(){
        fileReaderCoordinates = new FileReaderCoordinates();
    }

    @Test
    void readBSTInvalidFile() {
        Throwable resultString = null;
        try {
            KDtree<DataCoordinates> kDtree = fileReaderCoordinates.readCoordinates("teste.csv");
        } catch (Exception ex) {
            resultString = ex.getCause();
        }
        Throwable expectedString = null;

        assertEquals(expectedString, resultString);
    }

    @Test
    void testValidFile() throws IOException{
        KDtree<DataCoordinates> kDtree = fileReaderCoordinates.readCoordinates("Production_Crops_Livestock_E_AreaCoordinates_shuffled_v2.csv");
        Double expected = -3.373056;
        Double result= kDtree.root().getElement().getLatitude().getLatitude();

        assertEquals(expected,result);

    }

}