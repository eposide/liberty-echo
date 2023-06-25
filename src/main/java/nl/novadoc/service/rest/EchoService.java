package nl.novadoc.service.rest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("echo")
public class EchoService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getEcho() {
        return "liberty-echo saying Hello from " + getHostName();
    }


    private String getHostName() {

        String hostname = "Unknown";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }

        return hostname;
    }

}