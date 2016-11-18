package ch.bfh.gr33nopo55um.enocean;

/**
 * This interface provides basic encode and decode methods for EnOcean telegrams. Including description.
 *
 * @author louisjustussiegrist
 */
public interface EncodeDecode {

    /**
     * encode provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    String encode ();

    /**
     * decode splits telegram in parts
     *
     * @param hexTelegram
     */
    void decode (String hexTelegram);
}
