package ch.bfh.gr33nopo55um.enocean.application;

/**
 * Main Application starter
 *
 * @author silas
 */
public class Application {

    public static void main(String args[]) throws Exception {

        /*
           create the enoca Listener and run the logger.
        */
        EnoceaListener enoceaListener = new EnoceaListener();

        enoceaListener.logger();
    }

}
