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
    void CityParser() throws IOException {

        //given
        File csvData = new File("/Users/elkyschlesinger/IdeaProjects/schlesinger-world-cities/src/main/java/schlesinger/worldcities/worldcities.csv");
        CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);
        //when
        String city = parser.getRecords().get(5).get(0);
        //then
        assertEquals("Mumbai", city);
    }



}