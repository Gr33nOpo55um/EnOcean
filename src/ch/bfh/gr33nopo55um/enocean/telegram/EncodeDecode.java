package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * This interface provides basic encodeTelegram and decodeTelegramData methods for EnOcean telegrams. Including description.
 *
 * @author louisjustussiegrist
 */
interface EncodeDecode {

    /**
     * encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    String encodeTelegram();

    /**
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    void decodeTelegramData(String hexTelegram);

    /**
     * decodeHeaderTelegram splits telegram in parts
     *
     * @param hexTelegram EnOcean Telegram
     */
    void decodeTelegramHeader(String hexTelegram);
}
