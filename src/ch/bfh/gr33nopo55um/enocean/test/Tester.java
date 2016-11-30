package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.telegram.*;

/**
 * Created by silas on 25.11.16.
 */
public class Tester {


    public static void main(String args[]) {


        Tester tester = new Tester();
        //  tester.telegramRouter("0x55000707017af6000022a1342001ffffffff3a0035");

        //tester.erp2_test_decode("0x55000707017af6000022a1342001ffffffff3a0035");
        //   tester.telegramRouter("0x55000707017af6000022a1342001ffffffff3a0035");


        tester.erp1_test_decode("0x55000707017af6000022a1342001ffffffff3a0035");


    }

    private void telegramRouter(String hexTelegram) {


            /*
    0           Reserved
    1           RADIO_ERP1 Radio telegram
    2           Response to any packet
    3           Radio subtelegram
    4           Event message
    5           Common command
    6           Smart Ack command
    7           Remote management command
    8           Reserved for EnOcean
    9           Radio message
    10          ERP2 protocol radio telegram
    11-15       Reserved for EnOcean
    16          802_15_4_RAW Packet
    17          2.4 GHz Command
    18 - 127    Reserved for EnOcean
    128...255   available MSC and messages
     */
        TelegramHeader telegram = null;

        int packageType = 0;
        packageType = Integer.parseInt(hexTelegram.substring(10, 12), 16);

        if (packageType == 1) {
            telegram = new RadioERP1();


        } else if (packageType == 2) {
            telegram = new Response();


        } else if (packageType == 3) {
            telegram = new Radio();


        } else if (packageType == 4) {
            telegram = new Event();


        } else if (packageType == 5) {
            telegram = new CommonCommand();


        } else if (packageType == 6) {
            telegram = new SmartAckCommand();


        } else if (packageType == 7) {
            telegram = new SmartAckCommand();


        } else if (packageType == 8) {
            //Reserved for Enocean


        } else if (packageType == 9) {
            telegram = new Radio();


        } else if (packageType == 10) {
            telegram = new RadioERP2();


        } else if ((packageType >= 11) || (packageType <= 15)) {
            //Reserved for Enocean
        } else if (packageType == 16) {
            // 802_15_4_RAW Packet
        } else if (packageType == 17) {
            //2.4 GHz Command
        } else if ((packageType >= 18) || (packageType <= 127)) {
            //Reserved for Enocean
        } else if ((packageType >= 128) || (packageType <= 255)) {
            //available MSC and messages


        } else {
            System.err.println("No Telegram type found");
        }

        telegram.decodeTelegramHeader(hexTelegram);
        telegram.decodeTelegramData(hexTelegram);
        telegram.persist();
    }


    private void erp1_test_decode(String telegram) {

        RadioERP1 radioERP1 = new RadioERP1();

        radioERP1.decodeTelegram(telegram);


        radioERP1.dump();


        radioERP1.toString();
        radioERP1.persist();
    }

    private void erp2_test_decode(String telegram) {


        System.out.println("");
        System.out.println("Echo: erp2 telegram");
        RadioERP2 radioERP2 = new RadioERP2();

        radioERP2.decodeTelegram(telegram);

        radioERP2.dump();


        radioERP2.persist();

    }
}
