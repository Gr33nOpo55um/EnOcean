package ch.bfh.gr33nopo55um.enocean.telegram;

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

        syncByte = hexTelegram.substring(2, 4); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8)); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10)); //7

        packageType = hexTelegram.substring(10, 12); //01 for radio

        crcHeader = hexTelegram.substring(12, 14); //


        ccCode = Integer.parseInt(hexTelegram.substring(14, 16), 16);
        ccData = hexTelegram.substring(16, 24);

        crcData = hexTelegram.substring(24, 26);

    }
}
