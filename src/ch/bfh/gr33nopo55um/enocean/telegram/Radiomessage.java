package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Radiomessage extends TelegramHeader {
    private String destinationID;
    private String sourceID;
    private int dbm;


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

        destinationID = hexTelegram.substring(14, 22);

        sourceID = hexTelegram.substring(22, 30);

        dbm = Integer.parseInt(hexTelegram.substring(30, 32), 16);


        crcData = Integer.parseInt(hexTelegram.substring(32, 34), 16);


    }

    /**
     * dumpData Print Data, useful for logs and testiing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {

    }
}
