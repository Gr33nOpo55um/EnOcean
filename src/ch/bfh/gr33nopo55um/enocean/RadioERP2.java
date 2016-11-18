package ch.bfh.gr33nopo55um.enocean;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
public class RadioERP2 extends TelegramHeader{

    private int subTelNum;
    private int dbm;

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
