package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Table;


@Table
public class Event extends TelegramHeader {

    private int eventCode;
    private int EventData;

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
}
