package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.helper.TelegramDBFactory;

/**
 * Used for Testing telegrams
 *
 * @author silas
 */
public class Tester {


    public static void main(String args[]) {


        TelegramDBFactory telegramDBFactory = new TelegramDBFactory();

        // telegramDBFactory.telegramRouter("0x55000707017af6000022a1342001ffffffff3a0035");
        // telegramDBFactory.telegramRouter("0x55023456743af6000022a1342001ffffffff3a0035");

        telegramDBFactory.telegramRouter("0x55000a0701eba50000000c019134fc0001ffffffff3d002f");


    }


}
