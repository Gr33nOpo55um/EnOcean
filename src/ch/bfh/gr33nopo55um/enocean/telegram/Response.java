package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Table;


@Table
public class Response extends TelegramHeader{
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

    }
}
