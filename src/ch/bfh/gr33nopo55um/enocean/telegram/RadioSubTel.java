package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by silas on 18.11.16.
 */


@Entity
public class RadioSubTel extends TelegramHeader {


    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int subTelNum;
    private String destinationID;
    private int dbm;
    private int securityLevel;
    private String timeStamp;
    private String tickSubTel;
    private String dbmSubTel;
    private String statusSubTel;

    @Override
    public String toString() {
        return "RadioSubTel{" +
                "subTelNum=" + subTelNum +
                ", destinationID='" + destinationID + '\'' +
                ", dbm=" + dbm +
                ", securityLevel=" + securityLevel +
                ", timeStamp='" + timeStamp + '\'' +
                ", tickSubTel='" + tickSubTel + '\'' +
                ", dbmSubTel='" + dbmSubTel + '\'' +
                ", statusSubTel='" + statusSubTel + '\'' +
                '}';
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTickSubTel() {
        return tickSubTel;
    }

    public void setTickSubTel(String tickSubTel) {
        this.tickSubTel = tickSubTel;
    }

    public String getDbmSubTel() {
        return dbmSubTel;
    }

    public void setDbmSubTel(String dbmSubTel) {
        this.dbmSubTel = dbmSubTel;
    }

    public String getStatusSubTel() {
        return statusSubTel;
    }

    public void setStatusSubTel(String statusSubTel) {
        this.statusSubTel = statusSubTel;
    }

    /**
     * encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    @Override
    public String encodeTelegram() {
        return null;
    }


    /**
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {


        data = Integer.parseInt(hexTelegram.substring(14, 14 + dataLength), 16);

        subTelNum = Integer.parseInt(hexTelegram.substring(dataLength + 14, dataLength + 16), 16);

        destinationID = hexTelegram.substring(dataLength + 16, dataLength + 24);

        dbm = Integer.parseInt(hexTelegram.substring(dataLength + 24, dataLength + 26), 16);

        securityLevel = Integer.parseInt(hexTelegram.substring(dataLength + 26, dataLength + 28), 16);

        timeStamp = hexTelegram.substring(dataLength + 28, dataLength + 32);

        tickSubTel = hexTelegram.substring(dataLength + 32, dataLength + 34);

        dbmSubTel = hexTelegram.substring(dataLength + 34, dataLength + 36);

        statusSubTel = hexTelegram.substring(dataLength + 36, dataLength + 38);

        crcData = Integer.parseInt(hexTelegram.substring(dataLength + 38, dataLength + 40), 16); //

    }

    /**
     * dumpData Print Data, useful for logs and testiing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());
    }
}
