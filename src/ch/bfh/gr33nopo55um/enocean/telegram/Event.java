package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An EVENT is primarily a confirmation for processes and procedures, incl. specific data
 * content. For further informations check EnoceanSerialProtocol v3
 *
 * @author silas & louis
 */
@Entity
public class Event extends TelegramHeader {

    private int eventCode;
    private int EventData;

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

        this.setEventCode(Integer.parseInt(hexTelegram.substring(14, 16), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(16, 18), 16));


    }


    public int getEventCode() {
        return eventCode;
    }

    private void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public int getEventData() {
        return EventData;
    }

    public void setEventData(int eventData) {
        EventData = eventData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * dumpData Print Data, useful for logs and testing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "PacketType=Event" +
                " EventCode=" + eventCode +
                " EventData=" + EventData;
    }
}
