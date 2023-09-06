package schlesinger.worldcities;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

import java.io.IOException;

public class JettyMain {

    public static void main(String[] args) throws Exception{
        //Loads the server on port 8080
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(WorldCitiesServlet.class, "/worldCities");
        server.setHandler(handler);

        server.start();


    }
}
