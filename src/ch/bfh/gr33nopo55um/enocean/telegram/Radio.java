package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */


import javax.persistence.*;


@Entity
public class Radio extends TelegramHeader {

    private int messageRorg;
    private int messageData;

    private int destinationId;

    private int sourceId;
    private int dbm;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /**
     * encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    @Override
    public String encodeTelegram() {
        return null;
    }

    /**
     * decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {


        messageRorg = Integer.parseInt(hexTelegram.substring(14, 16), 16);
        messageData = Integer.parseInt(hexTelegram.substring(16, 16 + dataLength), 16);

        destinationId = Integer.parseInt(hexTelegram.substring(dataLength + 16, dataLength + 24), 16);

        sourceId = Integer.parseInt(hexTelegram.substring(dataLength + 24, dataLength + 32), 16);

        dbm = Integer.parseInt(hexTelegram.substring(dataLength + 32, dataLength + 34), 16);

        crcData = Integer.parseInt(hexTelegram.substring(dataLength + 34, dataLength + 36), 16);


    }

    /**
     * dumpData Print Data, useful for logs and testiing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {

    }
}
