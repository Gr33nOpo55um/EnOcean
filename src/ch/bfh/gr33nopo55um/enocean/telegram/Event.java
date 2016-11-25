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

        syncByte = hexTelegram.substring(2, 4); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8)); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10)); //7

        packageType = hexTelegram.substring(10, 12); //01 for radio

        crcHeader = hexTelegram.substring(12, 14); //

        eventCode = Integer.parseInt(hexTelegram.substring(14, 16), 16);

        crcData = hexTelegram.substring(16, 18);


    }
}
