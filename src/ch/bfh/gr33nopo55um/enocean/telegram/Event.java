package ch.bfh.gr33nopo55um.enocean.telegram;

/*
  Created by silas on 18.11.16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {


        eventCode = Integer.parseInt(hexTelegram.substring(14, 16), 16);

        crcData = Integer.parseInt(hexTelegram.substring(16, 18), 16);


    }


    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
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
     * dumpData Print Data, useful for logs and testiing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "Event{" +
                "eventCode=" + eventCode +
                ", EventData=" + EventData +
                '}';
    }
}
