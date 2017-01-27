package ch.bfh.gr33nopo55um.enocean.application;

import ch.bfh.gr33nopo55um.enocean.helper.ReadConfig;
import it.polito.elite.enocean.enj.communication.EnJConnection;
import it.polito.elite.enocean.enj.link.EnJLink;
import it.polito.elite.enocean.examples.SimpleDeviceListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * @author silas
 * @class Class which implements the Enj lib functions
 */
public class EnoceaListener {

    private static Logger logger = LogManager.getLogger();


    /**
     * @brief Logger for Serial port
     */
    public void logger() {


        ReadConfig readConfig = new ReadConfig();
        String serialPort;

        /**
         * @brief try to read config file, if something hapend unexptected, take default port.
         */
        try {
            serialPort = readConfig.readPropertyValue("serialPort");
        } catch (IOException e) {
            serialPort = "/dev/ttyUSB0";
            logger.warn("No config found, taking default Port instead: " + serialPort);

        }


        /**
         @brief
          * The EnJ link layer, uses the identifier of the serial port on which the gateway is connected
         */
        EnJLink linkLayer = null;
        try {
            linkLayer = new EnJLink(readConfig.readPropertyValue("serialPort")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         @brief
          * build the connection layer, which abstracts network peculiarities and provides an event-based access to connected devices
         */
        EnJConnection connection = new EnJConnection(linkLayer, null); //null persistent storage


        /**
         @brief
          * build a simple device listener to "listen" to device notifications
         */
        SimpleDeviceListener listener = new SimpleDeviceListener();


        /**
         * @brief add the listener to the connection layer
         *
         */
        connection.addEnJDeviceListener(listener);

        /**
         @brief connect the link to the physical network
         */
        linkLayer.connect();


    }


}
