package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.helper.TelegramFactory;

/**
 * Created by silas on 25.11.16.
 */
public class Tester {


    public static void main(String args[]) {


        TelegramFactory telegramFactory = new TelegramFactory();

        telegramFactory.telegramRouter("0x55000707017af6000022a1342001ffffffff3a0035");


    }


}
