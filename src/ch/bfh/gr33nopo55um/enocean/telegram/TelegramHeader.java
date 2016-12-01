package ch.bfh.gr33nopo55um.enocean.telegram;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;

import javax.persistence.MappedSuperclass;

/**
 * Created by silas on 18.11.16.
 */


@MappedSuperclass
public abstract class TelegramHeader implements EncodeDecode {


    private int telegram;
    int data;
    int syncByte;
    int dataLength;
    int optionalLenght;
    private int crcHeader;
    int crcData;
    Type packageType;

                /*
    0           Reserved
    1           RADIO_ERP1 Radio802 telegram
    2           Response to any packet
    3           Radio802 subtelegram
    4           Event message
    5           Common command
    6           Smart Ack command
    7           Remote management command
    8           Reserved for EnOcean
    9           Radio802 message
    10          ERP2 protocol radio telegram
    11-15       Reserved for EnOcean
    16          802_15_4_RAW Packet
    17          2.4 GHz Command
    18 - 127    Reserved for EnOcean
    128...255   available MSC and messages
     */


    public enum Type {
        RadioERP1,
        Response,
        RadioSubTel,
        Event,
        CommonCommand,
        SmartAckCommand,
        RemoteManCommand,
        RadioMessage,
        RadioERP2,
        Radio802;
        private int value;


    }


    private String fullTelegram;

    public String getFullTelegram() {
        return fullTelegram;
    }

    public void setFullTelegram(String fullTelegram) {
        this.fullTelegram = fullTelegram;
    }

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

    public Type getPackageType() {
        return packageType;
    }


    public void setPackageType(int tID) {


                        /*
    0           Reserved
    1           RADIO_ERP1 Radio802 telegram
    2           Response to any packet
    3           Radio802 subtelegram
    4           Event message
    5           Common command
    6           Smart Ack command
    7           Remote management command
    8           Reserved for EnOcean
    9           Radio802 message
    10          ERP2 protocol radio telegram
    11-15       Reserved for EnOcean
    16          802_15_4_RAW Packet
    17          2.4 GHz Command
    18 - 127    Reserved for EnOcean
    128...255   available MSC and messages
     */
        switch (tID) {
            case 1:
                packageType = Type.RadioERP1;
                break;
            case 2:
                packageType = Type.Response;
                break;
            case 3:
                packageType = Type.RadioSubTel;
                break;
            case 4:
                packageType = Type.Event;
                break;
            case 5:
                packageType = Type.CommonCommand;
                break;
            case 6:
                packageType = Type.SmartAckCommand;
                break;
            case 7:
                packageType = Type.RemoteManCommand;
                break;
            case 9:
                packageType = Type.Radio802;
                break;
            case 10:
                packageType = Type.RadioERP2;
                break;
        }


        this.packageType = packageType;
    }

    public void decodeTelegramHeader(String hexTelegram) {
        try {
            fullTelegram = hexTelegram;
            syncByte = Integer.parseInt(hexTelegram.substring(2, 4), 16);
            dataLength = Integer.parseInt(hexTelegram.substring(4, 8));
            optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10));

            this.setPackageType(Integer.parseInt(hexTelegram.substring(10, 12), 16));

            crcHeader = Integer.parseInt(hexTelegram.substring(12, 14), 16);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Could not parse Telegram Header");
        }


    }


    public void dumpHeader() {


        System.out.println("TelegramHeader " + packageType + "{" +
                "telegram=" + telegram +
                ", data=" + data +
                ", syncByte=" + syncByte +
                ", dataLength=" + dataLength +
                ", optionalLenght=" + optionalLenght +
                ", crcHeader=" + crcHeader +
                ", crcData=" + crcData +
                ", packageType=" + packageType +
                ", fullTelegram='" + fullTelegram + '\'' +
                '}');
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
