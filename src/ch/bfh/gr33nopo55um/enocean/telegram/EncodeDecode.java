package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * @author silas & louis
 * @class This interface provides basic encodeTelegram and decodeTelegramData methods for EnOcean telegrams.
 */
interface EncodeDecode {

    /**
     * @return String hexTelegram EnOcean Telegram
     * @brief encodeTelegram provides an example telegram hex for this packet type.
     */
    String encodeTelegram();

    /**
     * @return String hexTelegramHeader EnOcean Telegram
     * @brief encodeTelegramHeader provides an example header hex for this packet type.
     */
    String encodeTelegramHeader();

    /**
     * @return String hexTelegramData EnOcean Telegram
     * @brief encodeTelegramData provides an example data hex for this packet type.
     */
    String encodeTelegramData();

    /**
     * @param hexTelegram EnOcean Telegram
     * @brief decodeTelegram splits telegram in parts
     */
    void decodeTelegram(String hexTelegram);

    /**
     * @param hexTelegram EnOcean Telegram
     * @brief decodeHeaderTelegram splits telegram header in parts
     */
    void decodeTelegramHeader(String hexTelegram);

    /**
     * @param hexTelegram EnOcean Telegram
     * @brief decodeTelegramData splits telegram data in parts
     */
    void decodeTelegramData(String hexTelegram);

    /**
     * @brief dumpHeader Print Header, useful for logs and testing
     */
    void dumpHeader();

    /**
     * @brief dumpData Print Data, useful for logs and testing EnOcean Telegram
     */
    void dumpData();

    /**
     * @brief run both, the dumpHeader and the dumpData
     */
    void dump();

    /**
     * @brief persist saves object to database
     */
    void persist();

}