package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;
import ch.bfh.gr33nopo55um.enocean.telegram.*;

/**
 * Created by silas on 25.11.16.
 */
public class Tester {


    public static void main(String args[]) {

        Tester tester = new Tester();
        tester.erp1_test_decode("0x55000707017af6000022a1342001ffffffff3a0035");

        tester.erp2_test_decode("0x55000707017af6000022a1342001ffffffff3a0035");
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
        int packageType = 0;
        packageType = Integer.parseInt(hexTelegram.substring(10, 12), 16);

        if (packageType == 1) {
            RadioERP1 telegram = new RadioERP1();
        } else if (packageType == 2) {
            Response telegram = new Response();
        } else if (packageType == 3) {
            Radio telegram = new Radio();
        } else if (packageType == 4) {
            Event telegram = new Event();
        } else if (packageType == 5) {
            CommonCommand telegram = new CommonCommand();
        } else if (packageType == 6) {
            SmartAckCommand telegram = new SmartAckCommand();

        } else if (packageType == 7) {
            SmartAckCommand telegram = new SmartAckCommand();
        } else if (packageType == 8) {
            SmartAckCommand telegram = new SmartAckCommand();
        } else if (packageType == 9) {
            SmartAckCommand telegram = new SmartAckCommand();
        } else if (packageType == 10) {
            SmartAckCommand telegram = new SmartAckCommand();
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

            RadioSubTel telegram = new RadioSubTel();
        }


    }


    private void erp1_test_decode(String telegram) {

        RadioERP1 radioERP1 = new RadioERP1();
        radioERP1.decodeTelegramHeader(telegram);
        radioERP1.decodeTelegramData(telegram);


        System.out.println("Sync Byte:" + radioERP1.getSyncByte());
        System.out.println("Data Length:" + radioERP1.getDataLength());
        System.out.println("Optional Length:" + radioERP1.getOptionalLenght());
        System.out.println("Package Type:" + radioERP1.getPackageType());
        System.out.println("Header:" + radioERP1.getCrcHeader());
        System.out.println("Data:" + radioERP1.getData());

        System.out.println("SubTelNum:" + radioERP1.getSubTelNum());


        System.out.println("Destination" + radioERP1.getDestinationID());


        System.out.println("dbm:" + radioERP1.getDbm());
        System.out.println("securityLevel:" + radioERP1.getSecurityLevel());
        System.out.println("crcData:" + radioERP1.getData());

        Store.getInstance().getEntityManager().getTransaction().begin();
        Store.getInstance().getEntityManager().persist(radioERP1);
        Store.getInstance().getEntityManager().getTransaction().commit();
    }

    private void erp2_test_decode(String telegram) {


        System.out.println("");
        System.out.println("Echo: erp2 telegram");
        RadioERP2 radioERP2 = new RadioERP2();
        radioERP2.decodeTelegramHeader(telegram);
        radioERP2.decodeTelegramData(telegram);


        System.out.println("Sync Byte:" + radioERP2.getSyncByte());
        System.out.println("Data Length:" + radioERP2.getDataLength());
        System.out.println("Optional Length:" + radioERP2.getOptionalLenght());
        System.out.println("Package Type:" + radioERP2.getPackageType());
        System.out.println("Header:" + radioERP2.getCrcHeader());
        System.out.println("RawData:" + radioERP2.getRawData());


        System.out.println("subTelNum:" + radioERP2.getSubTelNum());
        System.out.println("dbm:" + radioERP2.getDbm());
        System.out.println("crcData:" + radioERP2.getCrcData());


        Store.getInstance().getEntityManager().getTransaction().begin();
        Store.getInstance().getEntityManager().persist(radioERP2);
        Store.getInstance().getEntityManager().getTransaction().commit();


    }
}
