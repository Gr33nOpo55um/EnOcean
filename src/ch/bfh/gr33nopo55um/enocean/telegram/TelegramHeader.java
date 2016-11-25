package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class TelegramHeader implements EncodeDecode {

    int telegram;
    int data;
    int syncByte;
    int dataLength;
    int optionalLenght;
    int crcHeader;
    int crcData;
    int packageType;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPackageType() {
        return packageType;
    }

    public void setPackageType(int packageType) {
        this.packageType = packageType;
    }

    public void decodeTelegramHeader(String hexTelegram) {

        syncByte = Integer.parseInt(hexTelegram.substring(2, 4), 16); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8)); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10)); //7

        packageType = Integer.parseInt(hexTelegram.substring(10, 12), 16); //01 for radio

        crcHeader = Integer.parseInt(hexTelegram.substring(12, 14), 16); //

    }
}
