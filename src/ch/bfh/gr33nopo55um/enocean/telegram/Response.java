package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Table;


@Table
public class Response extends TelegramHeader {
    private int returnCode;

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

        //header
        syncByte = hexTelegram.substring(2, 4); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8)); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10)); //7

        packageType = hexTelegram.substring(10, 12); //02 for response

        crcHeader = hexTelegram.substring(12, 14); //


        //data


        returnCode = Integer.parseInt(hexTelegram.substring(14, 4), 16);
        crcData = hexTelegram.substring(14, 16);

    }

}

