package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;
import ch.bfh.gr33nopo55um.enocean.telegram.RadioERP1;
import ch.bfh.gr33nopo55um.enocean.telegram.RadioERP2;

/**
 * Created by silas on 25.11.16.
 */
public class Tester {


    public static void main(String args[]) {

        Tester tester = new Tester();
        tester.erp1_tester("0x55000707017af6000022a1342001ffffffff3a0035");

        tester.erp2_tester("0x55000707017af6000022a1342001ffffffff3a0035");


    }

    private void erp1_tester(String telegram) {

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

    private void erp2_tester(String telegram) {


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
