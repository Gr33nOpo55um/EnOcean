package ch.bfh.gr33nopo55um.enocean.telegram;

/*
  Created by silas on 18.11.16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class RadioERP2 extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private int subTelNum;
    private int dbm;
    private String rawData;


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

        rawData = hexTelegram.substring(14, 26);
        subTelNum = Integer.parseInt(hexTelegram.substring(26, 28), 16);
        dbm = Integer.parseInt(hexTelegram.substring(28, 30), 16);
        crcData = Integer.parseInt(hexTelegram.substring(30, 32), 16);


    }

    public int getSubTelNum() {
        return subTelNum;
    }

    public void setSubTelNum(int subTelNum) {
        this.subTelNum = subTelNum;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    @Override
    public void dumpData() {
        System.out.println(this.toString());


    }

    @Override
    public String toString() {
        return "RadioERP2{" +
                "subTelNum=" + subTelNum +
                ", dbm=" + dbm +
                ", rawData='" + rawData + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
