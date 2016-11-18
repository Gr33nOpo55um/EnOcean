package ch.bfh.gr33nopo55um.enocean.telegram;

import java.util.Date;

/**
 * Created by silas on 18.11.16.
 */

import javax.persistence.Table;


@Table
public class RadioSubTel extends TelegramHeader{
private int id;
    private int subTelNum;
    private String destinationID;
    private int dbm;
    private String securityLevel;
    private Date timeStamp;
    private int tickSubTel;
    private int dbmSubTel;
    private String statusSubTel;

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
     * decodeTelegram splits telegram in parts
     *
     * @param hexTelegram
     */
    @Override
    public void decodeTelegram(String hexTelegram) {

    }
}
