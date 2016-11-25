package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */


import javax.persistence.Table;


@Table
public class Radio extends TelegramHeader {


    private int rssi;

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
     * decodeTelegram splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegram(String hexTelegram) {
        syncByte = hexTelegram.substring(2, 4); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8)); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10)); //7

        packageType = hexTelegram.substring(10, 12); //01 for radio

        crcData = hexTelegram.substring(12, 14); //

    }
}
