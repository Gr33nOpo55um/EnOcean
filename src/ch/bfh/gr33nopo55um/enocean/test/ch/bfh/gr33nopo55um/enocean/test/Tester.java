package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.helper.ReadConfig;
import ch.bfh.gr33nopo55um.enocean.helper.TelegramDBFactory;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Used for Testing telegrams
 *
 * @author silas
 */
public class Tester {

    private static Logger logger = LogManager.getLogger();

    public static void main(String args[]) {


        TelegramDBFactory telegramDBFactory = new TelegramDBFactory();

        // telegramDBFactory.telegramRouter("0x55000707017af6000022a1342001ffffffff3a0035");
        // telegramDBFactory.telegramRouter("0x55023456743af6000022a1342001ffffffff3a0035");

        telegramDBFactory.telegramRouter("0x55000a0701eba50000000c019134fc0001ffffffff3d002f");

        ReadConfig readConfig = new ReadConfig();
        try {
            System.out.println( readConfig.readPropertyValue("serialPort"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("EnOcean Telegram: HEX=0x55000a0701eba50000000c019134fc0001ffffffff3d002f DATA=...");



    }


}
