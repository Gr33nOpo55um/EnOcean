package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class RemoteManCommand extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String destinationID;
    private String sourceID;
    private int dbm;
    private int sendDelay;

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

        sendDelay = Integer.parseInt(hexTelegram.substring(32, 34), 16);

        crcData = Integer.parseInt(hexTelegram.substring(34, 36), 16);


    }
}
