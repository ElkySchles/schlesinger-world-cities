package schlesinger.worldcities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CityParser {


    String city;
    double latit;
    double longit;

    public CSVParser parser;
    //public ArrayList<CSVRecord> allInfo = new ArrayList<CSVRecord>();


    public CityParser() throws IOException {

        File csvData = new File("/Users/elkyschlesinger/IdeaProjects/schlesinger-world-cities/src/main/java/schlesinger/worldcities/worldcities.csv");
        parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);

    }

    public void calculateDistance(double lat, double lng) {

        double minimumDistance = Double.MAX_VALUE;

        Iterable<CSVRecord> records = parser.getRecords();
        for (CSVRecord record : records) {
            latit = Double.parseDouble(record.get(2));
            longit = Double.parseDouble(record.get(3));
            double distance = Math.sqrt(((lat - latit) * (lat - latit)) * ((lng - longit) * (lng - longit)));
            if (distance < minimumDistance) {
                minimumDistance = distance;
                city = record.get(0);
            }
        }

    }

    public String getCityInfo() {
            return city;
    }
    public double getLatitudeInfo(){
        return latit;
    }
    public double getLongitudeInfo(){
        return  longit;
    }

}

