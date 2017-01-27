package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author silas & louis
 * @class SMART_ACK_COMMAND (carries no Optional Data), for further informations check EnoceanSerialProtocol v3
 */
@Entity
public class SmartAckCommand extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int smartAckCommandNr;
    private int smartAckCommandData;

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

        this.setSyncByte(Integer.parseInt(hexTelegram.substring(2, 4), 16));
        this.setDataLength(Integer.parseInt(hexTelegram.substring(4, 8), 16));

        this.setOptionalLenght(Integer.parseInt(hexTelegram.substring(8, 10), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(12, 14), 16));


    }

    /**
     * @brief dumpData Print Data, useful for logs and testing
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PacketType=SmartAckCommand" +
                " SmartAckCommandNr=" + smartAckCommandNr +
                " SmartAckData=" + smartAckCommandData;
    }

    public int getSmartAckCommandNr() {
        return smartAckCommandNr;
    }

    public void setSmartAckCommandNr(int smartAckCommandNr) {
        this.smartAckCommandNr = smartAckCommandNr;
    }

    public int getSmartAckCommandData() {
        return smartAckCommandData;
    }

    public void setSmartAckCommandData(int smartAckCommandData) {
        this.smartAckCommandData = smartAckCommandData;
    }
}
