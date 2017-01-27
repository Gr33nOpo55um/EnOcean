package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author silas & louis
 * @class All telegram which cannot parsed into other tables.
 */
@Entity
public class Dummy extends TelegramHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Override
    public String encodeTelegram() {
        return null;
    }

    /**
     * encodeTelegramData provides an example data hex for this packet type.
     *
     * @return String hexTelegramData EnOcean Telegram
     */
    @Override
    public String encodeTelegramData() {
        return null;
    }


    /**
     * @param hexTelegram EnOcean Telegram
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {

    }

    /**
     * @brief usally a dummy package does not have any data
     */
    @Override
    public void dumpData() {
    }


    /**
     * @return PacketType=Dummy
     */
    @Override
    public String toString() {
        return "PacketType=Dummy";
    }
}
