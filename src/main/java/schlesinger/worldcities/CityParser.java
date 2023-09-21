package schlesinger.worldcities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CityParser {


    String city;

    double finalLatit;
    double finalLongit;

    public CSVParser parser;
    //public ArrayList<CSVRecord> allInfo = new ArrayList<CSVRecord>();


    public CityParser() throws IOException {
        InputStream inputStream = WorldCitiesServlet.class.getClassLoader()
                .getResourceAsStream("worldcities.csv");

        //File csvData = new File("src/main/resources/worldcities.csv");
        parser = CSVParser.parse(inputStream, Charset.defaultCharset(), CSVFormat.RFC4180);

    }

    public void calculateDistance(double lat, double lng) {
        double latit;
        double longit;

        double minimumDistance = Double.MAX_VALUE;

        Iterable<CSVRecord> records = parser.getRecords();
        for (CSVRecord record : records) {
            if (record.get(2).equals("lat") || record.get(3).equals("lng")) {
                latit = Double.MAX_VALUE;
                longit = Double.MAX_VALUE;
            } else {
                latit = Double.parseDouble(record.get(2));
                longit = Double.parseDouble(record.get(3));
                double distance = Math.sqrt(((lat - latit) * (lat - latit))
                        + ((lng - longit) * (lng - longit)));
                if (distance < minimumDistance) {
                    minimumDistance = distance;
                    city = record.get(0);
                    finalLatit = latit;
                    finalLongit = longit;
                }
            }
        }

    }

    public String getCityInfo() {
        return city;
    }

    public double getLatitudeInfo() {
        return finalLatit;
    }

    public double getLongitudeInfo() {
        return finalLongit;
    }

}

