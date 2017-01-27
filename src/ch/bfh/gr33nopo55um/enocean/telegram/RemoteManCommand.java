package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author silas & louis
 * @class remote management command structure. This structure is applied for the send as well as the receive case, for further informations check EnoceanSerialProtocol v3
 */
@Entity
public class RemoteManCommand extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destinationID;
    private String sourceID;
    private int dbm;
    private int sendDelay;

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


        this.setDestinationID(hexTelegram.substring(14, 22));

        this.setSourceID(hexTelegram.substring(22, 30));

        this.setDbm(Integer.parseInt(hexTelegram.substring(30, 32), 16));

        this.setSendDelay(Integer.parseInt(hexTelegram.substring(32, 34), 16));

        this.setCrcData(Integer.parseInt(hexTelegram.substring(34, 36), 16));


    }

    /**
     * @brief dumpData Print Data, useful for logs and testiing
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "PacketType=RemoteManCommand" +
                " DestinationID=" + destinationID +
                " SourceID=" + sourceID +
                " dBm=" + dbm +
                " SendWithDelay=" + sendDelay;
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

    public int getSendDelay() {
        return sendDelay;
    }

    private void setSendDelay(int sendDelay) {
        this.sendDelay = sendDelay;
    }
}
