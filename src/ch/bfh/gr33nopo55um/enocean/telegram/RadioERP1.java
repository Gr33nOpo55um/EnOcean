package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Table;


@Table
public class RadioERP1 extends TelegramHeader {


    private int subTelNum;
    private String destinationID;
    private int dbm;
    private int securityLevel;

    /**
     * encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    @Override
    public String encodeTelegram() {
        return null;
    }

    public int getSubTelNum() {
        return subTelNum;
    }

    public void setSubTelNum(int subTelNum) {
        this.subTelNum = subTelNum;
    }

    public String getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * decodeTelegram splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegram(String hexTelegram) {


        syncByte = hexTelegram.substring(2, 4); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8), 16); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10), 16); //7

        packageType = hexTelegram.substring(10, 12); //01 for radio

        crcHeader = hexTelegram.substring(12, 14); //

        //end of header

        //start of data
        int endOfDataLength = 14 + dataLength;

        data = hexTelegram.substring(14, endOfDataLength); //

        subTelNum = Integer.parseInt(hexTelegram.substring(endOfDataLength, endOfDataLength + 2), 16);


        destinationID = hexTelegram.substring(endOfDataLength + 2, endOfDataLength + 10);

        dbm = Integer.parseInt(hexTelegram.substring(endOfDataLength + 10, endOfDataLength + 12), 16);


        securityLevel = Integer.parseInt(hexTelegram.substring(endOfDataLength + 12, endOfDataLength + 14), 16);

        crcData = hexTelegram.substring(endOfDataLength + 14, endOfDataLength + 16);


    }
}
