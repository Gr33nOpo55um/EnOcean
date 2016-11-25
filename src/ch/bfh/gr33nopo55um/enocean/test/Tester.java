package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.telegram.RadioERP1;

/**
 * Created by silas on 25.11.16.
 */
public class Tester {


    public static void main(String args[]) {


        Tester.erp1_tester("0x55000707017af6000022a1342001ffffffff3a0035");
    }

    public static void erp1_tester(String telegram) {

        RadioERP1 radioERP1 = new RadioERP1();

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
    }
}
