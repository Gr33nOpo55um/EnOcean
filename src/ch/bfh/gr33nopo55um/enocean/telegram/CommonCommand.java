package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Serveral Commands, for further informations check EnoceanSerialProtocol v3
 *
 * @author silas & louis
 */
@SuppressWarnings("ALL")
public class CommonCommand extends TelegramHeader {

    private int ccCode;
    private int ccData;

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

        this.setCcCode(Integer.parseInt(hexTelegram.substring(14, 16), 16));
        this.setCcData(Integer.parseInt(hexTelegram.substring(16, 24), 16));
        this.setCrcData(crcData = Integer.parseInt(hexTelegram.substring(24, 26), 16));

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
