package ch.bfh.gr33nopo55um.enocean.application;

import it.polito.elite.enocean.enj.communication.EnJConnection;
import it.polito.elite.enocean.enj.link.EnJLink;
import it.polito.elite.enocean.examples.SimpleDeviceListener;

/**
 * Created by silas on 23.01.17.
 */
public class EnoceaListener {


    public void logger() {


        // The EnJ link layer, uses the identifier of the serial port on which the gateway is connected
        EnJLink linkLayer = null;
        try {
            linkLayer = new EnJLink("/dev/ttyUSB0");
        } catch (Exception e) {
            e.printStackTrace();
        }



        //   System.out.println(linkLayer.receive());

        // build the connection layer, which abstracts network peculiarities and
        // provides an event-based access to connected devices
        EnJConnection connection = new EnJConnection(linkLayer, null); //null persistent storage


        // build a simple device listener to "listen" to device notifications
        SimpleDeviceListener listener = new SimpleDeviceListener();


        // System.out.println( listener.toString());

        // add the listener to the connection layer
        connection.addEnJDeviceListener(listener);


        // connect the link to the physical network
        linkLayer.connect();




    }


}
