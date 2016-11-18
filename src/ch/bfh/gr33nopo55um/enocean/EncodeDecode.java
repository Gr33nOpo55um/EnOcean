package ch.bfh.gr33nopo55um.enocean;

/**
 * This interface provides basic encodeTelegram and decodeTelegram methods for EnOcean telegrams. Including description.
 *
 * @author louisjustussiegrist
 */
public interface EncodeDecode {

    /**
     * encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    String encodeTelegram();

    /**
     * decodeTelegram splits telegram in parts
     *
     * @param hexTelegram
     */
    void decodeTelegram(String hexTelegram);
}
