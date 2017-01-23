package ch.bfh.gr33nopo55um.enocean.telegram;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * ToDo description
 *
 * @author silas & louis
 */
@MappedSuperclass
public abstract class TelegramHeader implements EncodeDecode {


    int data;
    int syncByte;
    int dataLength;
    int crcData;
    private int optionalLenght;
    private int crcHeader;

    @Column(name="creationDate")
    private Timestamp creationDate;
    private String fullTelegram;

    public Timestamp getCreationDate() {
        return creationDate;
    }

    private void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String encodeTelegram() {
        return encodeTelegramHeader() + encodeTelegramData();
    }

    public String encodeTelegramHeader() {
        return null;
    }

    public void decodeTelegram(String hexTelegram) {
        decodeTelegramHeader(hexTelegram);
        decodeTelegramData(hexTelegram);
    }

    public void decodeTelegramHeader(String hexTelegram) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.setCreationDate(timestamp);
        this.setFullTelegram(hexTelegram);
        this.setSyncByte(Integer.parseInt(hexTelegram.substring(2, 4), 16));
        this.setDataLength(Integer.parseInt(hexTelegram.substring(4, 8)));
        this.setOptionalLenght(Integer.parseInt(hexTelegram.substring(8, 10)));
        this.setCrcHeader(Integer.parseInt(hexTelegram.substring(12, 14), 16));
    }

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


    public void dumpHeader() {


        System.out.println("TelegramHeader{" +
                "data=" + data +
                ", syncByte=" + syncByte +
                ", dataLength=" + dataLength +
                ", optionalLenght=" + optionalLenght +
                ", crcData=" + crcData +
                ", crcHeader=" + crcHeader +
                ", creationDate=" + creationDate +
                ", fullTelegram='" + fullTelegram + '\'' + '}' + '}');

    }


    public void persist() {

        Store.getInstance().getEntityManager().getTransaction().begin();
        Store.getInstance().getEntityManager().persist(this);
        Store.getInstance().getEntityManager().getTransaction().commit();


    }

    public void dump() {

        System.out.println("Echo: " + this.getClass().toString() + "telegram");

        dumpHeader();
        dumpData();
    }

}
