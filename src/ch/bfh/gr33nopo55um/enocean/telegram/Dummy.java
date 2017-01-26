package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * All telegram which cannot parsed into other tables.
 *
 * @author silas & louis
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

    @Override
    public void decodeTelegramData(String hexTelegram) {

    }

    @Override
    public void dumpData() {

    }

    @Override
    public String toString() {
        return "PacketType=Dummy";
    }
}
