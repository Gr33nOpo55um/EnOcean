package ch.bfh.gr33nopo55um.enocean.telegram;

/*
  Created by silas on 18.11.16.
 */

import javax.persistence.*;

@Entity
public class RadioERP1
        extends TelegramHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {


        //start of data
        int endOfDataLength = 14 + dataLength;


        this.setData(Integer.parseInt(hexTelegram.substring(14, endOfDataLength), 16));
        this.setSubTelNum(Integer.parseInt(hexTelegram.substring(endOfDataLength, endOfDataLength + 2), 16));
        this.setDestinationID(hexTelegram.substring(endOfDataLength + 2, endOfDataLength + 10));
        this.setDbm(Integer.parseInt(hexTelegram.substring(endOfDataLength + 10, endOfDataLength + 12), 16));
        this.setSecurityLevel(Integer.parseInt(hexTelegram.substring(endOfDataLength + 12, endOfDataLength + 14), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(endOfDataLength + 14, endOfDataLength + 16), 16));


    }

    public void dumpData() {

        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "RadioERP1{" +
                "subTelNum=" + subTelNum +
                ", destinationID='" + destinationID + '\'' +
                ", dbm=" + dbm +
                ", securityLevel=" + securityLevel +
                '}';
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
