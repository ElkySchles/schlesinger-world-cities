package schlesinger.worldcities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class CityParserTest {
    @Test
    public void calculateDistance() throws IOException {

        //given

        CityParser parser = new CityParser();
        double lat = 39.1050;
        double lng = -96.6200;

        //when
        parser.calculateDistance(lat, lng);
        String city = parser.getCityInfo();
        Double finalLat = parser.getLatitudeInfo();
        Double finalLon = parser.getLongitudeInfo();

        //then
        assertEquals("Manhattan", city);
        assertEquals(39.1886 , finalLat);
        assertEquals(-96.6048, finalLon);
    }



}