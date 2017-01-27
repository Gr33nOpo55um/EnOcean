package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @class Radio message (payload data without any radio telegram contents, for further informations check EnoceanSerialProtocol v3
 *
 * @author silas & louis
 */
@Entity
public class RadioMessage extends TelegramHeader {
    private String destinationID;
    private String sourceID;
    private int dbm;

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

    /**
     * encodeTelegramData provides an example data hex for this packet type.
     *
     * @return String hexTelegramData EnOcean Telegram
     */
    @Override
    public String encodeTelegramData() {
        return null;
    }

    /**
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram in hex String
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {

        this.setDestinationID(hexTelegram.substring(14, 22));
        this.setSourceID(hexTelegram.substring(22, 30));
        this.setDbm(Integer.parseInt(hexTelegram.substring(30, 32), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(32, 34), 16));
    }

    /**
     * dumpData Print Data, useful for logs and testiing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString()
        );
    }

    public String getDestinationID() {
        return destinationID;
    }

    private void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }

    public String getSourceID() {
        return sourceID;
    }

    private void setSourceID(String sourceID) {
        this.sourceID = sourceID;
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

    @Override
    public String toString() {
        return "PacketType=RadioMessage" +
                " DestinationID=" + destinationID +
                " SourceID=" + sourceID +
                " dBm=" + dbm;
    }
}
