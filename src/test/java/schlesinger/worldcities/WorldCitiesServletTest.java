package schlesinger.worldcities;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WorldCitiesServletTest {
    @Test
    public void doGet() throws ServletException, IOException {
        //given
        Gson gson = new Gson();
        CityParser parser = mock();
        WorldCitiesServlet servlet = new WorldCitiesServlet(parser, gson);
        HttpServletRequest request = mock();
        doReturn("40.7834").when(request).getParameter("lat");
        doReturn("-73.9662").when(request).getParameter("lng");
        doReturn("Manhattan").when(parser).getCityInfo();
        doReturn(40.7834).when(parser).getLongitudeInfo();
        doReturn(-73.9662).when(parser).getLatitudeInfo();


        HttpServletResponse response = mock();
        PrintWriter out = mock();
        doReturn(out).when(response).getWriter();
        //when
        servlet.doGet(request, response);
        //then
        verify(response).setContentType("text/json");
        verify(out).println(anyString());
    }
}