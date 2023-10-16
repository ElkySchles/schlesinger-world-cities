package schlesinger.worldcities;

import com.google.gson.Gson;


import java.io.Console;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorldCitiesServlet extends HttpServlet {
    Double lat1;
    Double lng1;
    CityParser parser;

    private Gson gson;

    //this is used by Jetty
    public WorldCitiesServlet() throws IOException {
        this(new CityParser(), new Gson());
    }


    //this is used in tests
    public WorldCitiesServlet(CityParser parser, Gson gson)
    {
        this.gson = gson;
        this.parser = parser;
    }



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

        CityResponse cityResponse = new CityResponse(parser.getCityInfo(),
                parser.getLatitudeInfo(), parser.getLongitudeInfo());
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(cityResponse));

    }
}
