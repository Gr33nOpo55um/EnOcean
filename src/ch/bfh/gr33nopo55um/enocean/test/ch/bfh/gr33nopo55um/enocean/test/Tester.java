package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.helper.ReadConfig;
import ch.bfh.gr33nopo55um.enocean.helper.TelegramDBFactory;
import ch.bfh.gr33nopo55um.enocean.helper.TimeLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Used for Testing telegrams
 *
 * @author silas
 */
public class Tester {

    private static Logger logger = LogManager.getLogger();

    public static void main(String args[]) {


        TimeLogger timeLogger = new TimeLogger();

        timeLogger.startLogTime();
        timeLogger.setOperationName("Application");

        TelegramDBFactory telegramDBFactory = new TelegramDBFactory();

        /*
        * Loop for masstesting
        */
        for (int i = 0; i < 20; i++) {
            telegramDBFactory.telegramRouter("0x55000707017af6000022a1342001ffffffff3a0035");
            telegramDBFactory.telegramRouter("0x55000a0701eba50000000c019134fc0001ffffffff3d002f");
        }
        ReadConfig readConfig = new ReadConfig();
        try {
            System.out.println(readConfig.readPropertyValue("serialPort"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        timeLogger.endLogTime();
    }


}
