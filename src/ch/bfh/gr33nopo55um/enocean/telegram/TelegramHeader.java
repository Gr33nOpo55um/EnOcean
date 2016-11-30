package ch.bfh.gr33nopo55um.enocean.telegram;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;

import javax.persistence.MappedSuperclass;

/**
 * Created by silas on 18.11.16.
 */


@MappedSuperclass
public abstract class TelegramHeader implements EncodeDecode {


    int telegram;
    int data;
    int syncByte;
    int dataLength;
    int optionalLenght;
    int crcHeader;
    int crcData;
    int packageType;

    String fullTelegram;


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getTelegram() {
        return telegram;
    }

    public void setTelegram(int telegram) {
        this.telegram = telegram;
    }

    public int getSyncByte() {
        return syncByte;
    }

    public void setSyncByte(int syncByte) {
        this.syncByte = syncByte;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public int getOptionalLenght() {
        return optionalLenght;
    }

    public void setOptionalLenght(int optionalLenght) {
        this.optionalLenght = optionalLenght;
    }

    public int getCrcHeader() {
        return crcHeader;
    }

    public void setCrcHeader(int crcHeader) {
        this.crcHeader = crcHeader;
    }

    public int getCrcData() {
        return crcData;
    }

    public void setCrcData(int crcData) {
        this.crcData = crcData;
    }

    public int getPackageType() {
        return packageType;
    }

    public void setPackageType(int packageType) {
        this.packageType = packageType;
    }

    public void decodeTelegramHeader(String hexTelegram) {

        fullTelegram = hexTelegram;
        syncByte = Integer.parseInt(hexTelegram.substring(2, 4), 16);
        dataLength = Integer.parseInt(hexTelegram.substring(4, 8));
        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10));
        packageType = Integer.parseInt(hexTelegram.substring(10, 12), 16);
        crcHeader = Integer.parseInt(hexTelegram.substring(12, 14), 16);

    }

    public void dumpHeader() {

        System.out.println("Sync Byte:" + this.getSyncByte());
        System.out.println("Data Length:" + this.getDataLength());
        System.out.println("Optional Length:" + this.getOptionalLenght());
        System.out.println("Package Type:" + this.getPackageType());
        System.out.println("Header:" + this.getCrcHeader());
        System.out.println("Data:" + this.getData());
        System.out.println("crcData:" + this.getData());

    }


    public void persist() {

        Store.getInstance().getEntityManager().getTransaction().begin();
        Store.getInstance().getEntityManager().persist(this);
        Store.getInstance().getEntityManager().getTransaction().commit();

    }

    public void decodeTelegram(String hexTelegram) {
        decodeTelegramHeader(hexTelegram);
        decodeTelegramData(hexTelegram);
    }

    public void dump() {

        System.out.println("Echo: " + this.getClass().toString() + "telegram");

        dumpHeader();
        dumpData();
    }

}
