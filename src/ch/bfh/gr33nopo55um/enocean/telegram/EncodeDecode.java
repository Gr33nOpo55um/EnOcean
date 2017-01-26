package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * This interface provides basic encodeTelegram and decodeTelegramData methods for EnOcean telegrams.
 *
 * @author silas & louis
 */
interface EncodeDecode {

    /**
     * encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return String hexTelegram EnOcean Telegram
     */
    String encodeTelegram();

    /**
     * encodeTelegramHeader provides an example header hex for this packet type.
     *
     * @return String hexTelegramHeader EnOcean Telegram
     */
    String encodeTelegramHeader();

    /**
     * encodeTelegramData provides an example data hex for this packet type.
     *
     * @return String hexTelegramData EnOcean Telegram
     */
    String encodeTelegramData();

    /**
     * decodeTelegram splits telegram in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    void decodeTelegram(String hexTelegram);

    /**
     * decodeHeaderTelegram splits telegram header in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    void decodeTelegramHeader(String hexTelegram);

    /**
     * decodeTelegramData splits telegram data in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    void decodeTelegramData(String hexTelegram);

    /**
     * dumpHeader Print Header, useful for logs and testing
     * <p>
     * EnOcean Telegram
     */
    void dumpHeader();

    /**
     * dumpData Print Data, useful for logs and testing
     * <p>
     * EnOcean Telegram
     */
    void dumpData();

    /**
     * run both, the dumpHeader and the dumpData
     */
    void dump();

    /**
     * persist saves object to database
     */
    void persist();

}