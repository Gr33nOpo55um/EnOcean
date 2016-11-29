package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class RadioERP1
        extends TelegramHeader {


    private int subTelNum;
    private String destinationID;
    private int dbm;
    private int securityLevel;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {


        //start of data
        int endOfDataLength = 14 + dataLength;

        System.out.print(dataLength);

        data = Integer.parseInt(hexTelegram.substring(14, endOfDataLength), 16); //

        subTelNum = Integer.parseInt(hexTelegram.substring(endOfDataLength, endOfDataLength + 2), 16);


        destinationID = hexTelegram.substring(endOfDataLength + 2, endOfDataLength + 10);

        dbm = Integer.parseInt(hexTelegram.substring(endOfDataLength + 10, endOfDataLength + 12), 16);


        securityLevel = Integer.parseInt(hexTelegram.substring(endOfDataLength + 12, endOfDataLength + 14), 16);

        crcData = Integer.parseInt(hexTelegram.substring(endOfDataLength + 14, endOfDataLength + 16), 16);


    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
