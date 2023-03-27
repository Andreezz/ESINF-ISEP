package app.controller;
import app.model.Value;
import app.structure.Data;

import app.structure.FileReaderData;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class MinimalQuantityController
{

    public MinimalQuantityController()
    {

    }
    /**
     * @param Q quantity to test the problem
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public int minimalNumber(Value Q) throws IOException, ParseException
    {
        Map<String, Long> minimoCountry = new HashMap<String, Long>();
        ArrayList<Data> fileReaderData;
        fileReaderData = new FileReaderData().readData("C:\\Users\\andre\\Desktop\\isep\\2ºano\\Esinf\\Trabalho1\\src\\FAOSTAT_data_en_9-7-2022_BIG.csv");
        //fileReaderData = new FileReaderData().readData("/Users/joaogomes/Desktop/ISEP/ESINF/Trabalho_ESINF/FAOSTAT_data_9-7-2022/FAOSTAT_data_en_9-7-2022_BIG.csv");

          for(Data data : fileReaderData)
          {
              if(minimoCountry.containsKey(data.getAreaCode()))
              {
                  long sum = minimoCountry.get(data.getAreaCode()) + data.getValue().getValue().longValue();
                  minimoCountry.put(data.getAreaCode(), sum); //put in the map the values
              }
              else
              {
                  minimoCountry.put(data.getAreaCode(), data.getValue().getValue().longValue());
              }

          }

          long somaCountries = 0;
          int numberOfCountries = 0;
          SortedSet<String> keys = new TreeSet<>(minimoCountry.keySet()); //Sort all the values
          for (String key : keys)
          {
              somaCountries += minimoCountry.get(key); //Adds the values of production related to the same countries
              numberOfCountries++; //Increment the number of countries necessaries to achieve the maxium value of production

              if (somaCountries > Q.getValue())
              {
                  return numberOfCountries;
              }
          }

          return 0;
    }
}
