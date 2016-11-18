package ch.bfh.gr33nopo55um.enocean;

/**
 * Created by silas on 18.11.16.
 */
public abstract class TelegramHeader {

    private String data;
    private String telegram;
    private String syncByte;
    private int dataLength;
    private int optionalLenght;
    private String crcHeader;
    private String crdData;
}
