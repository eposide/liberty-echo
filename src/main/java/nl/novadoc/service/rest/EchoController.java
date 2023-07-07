package nl.novadoc.service.rest;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/echo")
@Singleton
public class EchoController {

    @GET
    public String getEcho() {
        return "liberty-echo saying Hello from " + getHostName() + " : " + getHostAddress();
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

    private String getHostAddress() {


        String hostAddress = "Unknown";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("HostAddress can not be resolved");
        }

        return hostAddress;
    }



}