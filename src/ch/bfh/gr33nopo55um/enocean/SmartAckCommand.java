package ch.bfh.gr33nopo55um.enocean;

/**
 * Created by silas on 18.11.16.
 */


import javax.persistence.Id;
import javax.persistence.Table;


@Table
public class SmartAckCommand extends TelegramHeader {
    private int smartAckCommandNr;
    private String smartAckCommandData;

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
