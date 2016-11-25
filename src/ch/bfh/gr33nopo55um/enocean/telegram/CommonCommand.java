package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */
public class CommonCommand extends TelegramHeader {

    private int ccCode;
    private int ccData;

    @Override
    public String encodeTelegram() {
        return null;
    }

    @Override
    public void decodeTelegramData(String hexTelegram) {




        ccCode = Integer.parseInt(hexTelegram.substring(14, 16), 16);
        ccData = Integer.parseInt(hexTelegram.substring(16, 24),16);

        crcData = Integer.parseInt(hexTelegram.substring(24, 26),16);

    }

    /**
     * decodeHeaderTelegram splits telegram in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    @Override
    public void decodeTelegramHeader(String hexTelegram) {

    }
}
