package ch.bfh.gr33nopo55um.enocean.application;

/**
 * @author silas
 * @class Main Application starter
 */
public class Application {

    public static void main(String args[]) throws Exception {

        /**
         @brief create the enoca Listener and run the logger.
         */
        EnoceaListener enoceaListener = new EnoceaListener();

        enoceaListener.logger();
    }

}
