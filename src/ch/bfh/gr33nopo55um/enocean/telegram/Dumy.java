package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by stegmuellerp on 05.12.2016.
 */

@Entity
public class Dumy extends TelegramHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Override
    public String encodeTelegram() {
        return null;
    }

    @Override
    public void decodeTelegramData(String hexTelegram) {

    }

    @Override
    public void dumpData() {

    }


}
