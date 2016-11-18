package ch.bfh.gr33nopo55um.enocean.telegram;

/**
 * Created by silas on 18.11.16.
 */

import ch.bfh.gr33nopo55um.enocean.EncodeDecode;

import javax.persistence.Id;

public abstract class TelegramHeader implements EncodeDecode {

    @Id
    public int id;
    public String data;
    public String telegram;
    public String syncByte;
    public int dataLength;
    public int optionalLenght;
    public String crcHeader;
    public String crdData;
}
