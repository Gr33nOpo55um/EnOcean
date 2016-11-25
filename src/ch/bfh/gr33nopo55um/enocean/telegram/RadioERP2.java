package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Table;


@Table
public class RadioERP2 extends TelegramHeader {

    private int subTelNum;
    private int dbm;
    private String rawData;


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




        rawData = hexTelegram.substring(14, 26);

        subTelNum = Integer.parseInt(hexTelegram.substring(26, 28), 16);


        dbm = Integer.parseInt(hexTelegram.substring(28, 30), 16);


        crcData = Integer.parseInt(hexTelegram.substring(30, 32),16);


    }
}
