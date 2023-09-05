package schlesinger.worldcities;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
public class WorldCitiesServlet extends HttpServlet {
    Double lat1;
    Double lng1;
    CityParser parser;


    {
        try {
            parser = new CityParser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final Gson gson = new Gson();



    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {


        String lat = req.getParameter("lat");
        String lng = req.getParameter("lng");
        lat1 = Double.parseDouble(lat);
        lng1 = Double.parseDouble(lng);
        parser.calculateDistance(lat1, lng1);
        //String definition = dictionary.getDefinition(word);
        CityResponse cityResponse = new CityResponse(parser.getCityInfo(), parser.getLatitudeInfo(), parser.getLongitudeInfo());
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(cityResponse));

    }
}
