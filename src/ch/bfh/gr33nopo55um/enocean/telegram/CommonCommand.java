package ch.bfh.gr33nopo55um.enocean.telegram;

import ch.bfh.gr33nopo55um.enocean.telegram.TelegramHeader;

/**
 * Created by silas on 18.11.16.
 */
public class CommonCommand extends TelegramHeader {

    private int ccCode;
    private String ccData;

    @Override
    public String encodeTelegram() {
        return null;
    }

    @Override
    public void decodeTelegram(String hexTelegram) {

    }
}
