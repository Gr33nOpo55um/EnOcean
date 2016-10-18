package testapp;

import it.polito.elite.enocean.enj.communication.EnJConnection;
import it.polito.elite.enocean.enj.link.EnJLink;
import testapp.examples.*;

/**
 * Created by silas on 07.10.16.
 */
public class Main {


    public static void main(String[] args) {
        // The EnJ link layer, uses the identifier of the serial port on which the gateway is connected
        EnJLink linkLayer = null;
        try {
            linkLayer = new EnJLink("/dev/ttyUSB0");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // build the connection layer, which abstracts network peculiarities and
// provides an event-based access to connected devices
        EnJConnection connection = new EnJConnection(linkLayer, null); //null persistent storage
        SimpleDeviceListener listener = new SimpleDeviceListener();

// add the listener to the connection layer
        connection.addEnJDeviceListener(listener);

// connect the link to the physical network
        linkLayer.connect();
    }

}
