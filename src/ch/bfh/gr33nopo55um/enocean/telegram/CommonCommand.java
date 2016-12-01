package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */
@SuppressWarnings("ALL")
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
        ccData = Integer.parseInt(hexTelegram.substring(16, 24), 16);
        crcData = Integer.parseInt(hexTelegram.substring(24, 26), 16);

    }


    public int getCcCode() {
        return ccCode;
    }

    public void setCcCode(int ccCode) {
        this.ccCode = ccCode;
    }

    public int getCcData() {
        return ccData;
    }

    public void setCcData(int ccData) {
        this.ccData = ccData;
    }

    /**
     * decodeHeaderTelegram splits telegram in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    @Override
    public void decodeTelegramHeader(String hexTelegram) {

    }

    /**
     * dumpData Print Data, useful for logs and testing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());

    }


    @Override
    public String toString() {
        return "CommonCommand{" +
                "ccCode=" + ccCode +
                ", ccData=" + ccData +
                '}';
    }
}
