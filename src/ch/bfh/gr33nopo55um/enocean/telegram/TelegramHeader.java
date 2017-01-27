package ch.bfh.gr33nopo55um.enocean.telegram;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author silas & louis
 * @class TelegramHeader is used for all common fields of the telegrams. It also implements the Store procedure.
 */
@MappedSuperclass
public abstract class TelegramHeader implements EncodeDecode {


    int dataLength;
    int crcData;
    //some data could be longer than int
    private Long data;
    private int syncByte;
    private int optionalLenght;
    private int crcHeader;

    @Column(name = "creationDate")
    private Timestamp creationDate;
    private String fullTelegram;


    /**
     * @return creationDate
     */
    public Timestamp getCreationDate() {
        return creationDate;
    }


    /**
     * @param creationDate
     */
    private void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return full telegram, header and data
     */
    public String encodeTelegram() {
        return encodeTelegramHeader() + encodeTelegramData();
    }


    /**
     * @return null, telegram header does not contain any data
     */
    public String encodeTelegramHeader() {
        return null;
    }

    /**
     * @param hexTelegram EnOcean Telegram
     */
    public void decodeTelegram(String hexTelegram) {
        decodeTelegramHeader(hexTelegram);
        decodeTelegramData(hexTelegram);
    }

    /**
     * @param hexTelegram EnOcean Telegram
     */
    public void decodeTelegramHeader(String hexTelegram) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.setCreationDate(timestamp);
        this.setFullTelegram(hexTelegram);
        this.setSyncByte(Integer.parseInt(hexTelegram.substring(2, 4), 16));
        this.setDataLength(Integer.parseInt(hexTelegram.substring(4, 8), 16));
        this.setOptionalLenght(Integer.parseInt(hexTelegram.substring(8, 10), 16));
        this.setCrcHeader(Integer.parseInt(hexTelegram.substring(12, 14), 16));
    }


    /**
     * @return full Telegram, helpful for finding persistence issues
     */
    public String getFullTelegram() {
        return fullTelegram;
    }

    /**
     * @param fullTelegram in hex String
     */

    private void setFullTelegram(String fullTelegram) {
        this.fullTelegram = fullTelegram;
    }


    /**
     * @return Telegram data Data of the Telegram
     */
    public Long getData() {
        return data;
    }


    /**
     * @param data Data of the Telegram
     */
    void setData(Long data) {
        this.data = data;
    }

    /**
     * @return syncByte is used to determine that the String recieved by Serial is an enocean Telegram
     */
    public int getSyncByte() {
        return syncByte;
    }

    /**
     * @param syncByte is used to determine that the String recieved by Serial is an enocean Telegram
     */
    void setSyncByte(int syncByte) {
        this.syncByte = syncByte;
    }


    /**
     * @return data Length, also used to determine package length
     */
    public int getDataLength() {
        return dataLength;
    }


    /**
     * @param dataLength is used for mandatory data length
     */
    void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    /**
     * @return optional Length, used for additional package information
     */
    public int getOptionalLenght() {
        return optionalLenght;
    }


    /**
     * @param optionalLenght is used for additional data
     */
    void setOptionalLenght(int optionalLenght) {
        this.optionalLenght = optionalLenght;
    }


    /**
     * @return header checksum
     */
    public int getCrcHeader() {
        return crcHeader;
    }


    /**
     * @param crcHeader checksum for header
     */
    private void setCrcHeader(int crcHeader) {
        this.crcHeader = crcHeader;
    }


    /**
     * @return data checksum
     */
    public int getCrcData() {
        return crcData;
    }

    /**
     * @param crcData checksum for data
     */
    void setCrcData(int crcData) {
        this.crcData = crcData;
    }

    /**
     * @brief print Header in pretty print
     */
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

    /**
     * @brief Create an entity manager and persist the current object.
     */
    public void persist() {

        Store.getInstance().getEntityManager().getTransaction().begin();
        Store.getInstance().getEntityManager().persist(this);
        Store.getInstance().getEntityManager().getTransaction().commit();


    }


    /**
     * @brief Used for debugging purposes
     */
    public void dump() {

        System.out.println("Echo: " + this.getClass().toString() + "telegram");

        dumpHeader();
        dumpData();
    }

}
