package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class TelegramHeader implements EncodeDecode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String data;
    public String telegram;
    public String syncByte;
    public int dataLength;
    public int optionalLenght;
    public String crcHeader;
    public String crcData;
    public String packageType;

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getSyncByte() {
        return syncByte;
    }

    public void setSyncByte(String syncByte) {
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

    public String getCrcHeader() {
        return crcHeader;
    }

    public void setCrcHeader(String crcHeader) {
        this.crcHeader = crcHeader;
    }

    public String getCrcData() {
        return crcData;
    }

    public void setCrcData(String crcData) {
        this.crcData = crcData;
    }
}
