package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author silas & louis
 * @class Physical Raw Packet, for further informations check EnoceanSerialProtocol v3
 */
@Entity
public class Radio802 extends TelegramHeader {

    private int messageRorg;
    private int messageData;

    private int destinationId;

    private int sourceId;
    private int dbm;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /**
     * @return telegram hex
     * @brief encodeTelegram provides an example telegram hex for this packet type.
     */
    @Override
    public String encodeTelegram() {
        return null;
    }

    /**
     * @return String hexTelegramData EnOcean Telegram
     * @brief encodeTelegramData provides an example data hex for this packet type.
     */
    @Override
    public String encodeTelegramData() {
        return null;
    }

    /**
     * @param hexTelegram in hex String
     * @brief decodeTelegramData splits telegram in parts
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {

        this.setMessageRorg(Integer.parseInt(hexTelegram.substring(14, 16), 16));
        this.setMessageData(Integer.parseInt(hexTelegram.substring(16, 16 + dataLength), 16));
        this.setDestinationId(Integer.parseInt(hexTelegram.substring(dataLength + 16, dataLength + 24), 16));
        this.setSourceId(Integer.parseInt(hexTelegram.substring(dataLength + 24, dataLength + 32), 16));
        this.setDbm(Integer.parseInt(hexTelegram.substring(dataLength + 32, dataLength + 34), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(dataLength + 34, dataLength + 36), 16));


    }

    public int getMessageRorg() {
        return messageRorg;
    }

    private void setMessageRorg(int messageRorg) {
        this.messageRorg = messageRorg;
    }

    public int getMessageData() {
        return messageData;
    }

    private void setMessageData(int messageData) {
        this.messageData = messageData;
    }

    public int getDestinationId() {
        return destinationId;
    }

    private void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getSourceId() {
        return sourceId;
    }

    private void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getDbm() {
        return dbm;
    }

    private void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @brief dumpData Print Data, useful for logs and testiing
     */
    @Override
    public void dumpData() {

        System.out.println(this.toString());

    }

    /*
    @brief pretty print
     */
    @Override
    public String toString() {
        return "PacketType=Radio802" +
                " messageRorg=" + messageRorg +
                " messageData=" + messageData +
                " destinationId=" + destinationId +
                " sourceId=" + sourceId +
                " dbm=" + dbm;
    }
}
