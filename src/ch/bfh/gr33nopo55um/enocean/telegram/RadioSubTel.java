package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Table;

/**
 * Created by silas on 18.11.16.
 */


@Table
public class RadioSubTel extends TelegramHeader {
    private int id;
    private int subTelNum;
    private String destinationID;
    private int dbm;
    private int securityLevel;
    private String timeStamp;
    private String tickSubTel;
    private String dbmSubTel;
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
        syncByte = hexTelegram.substring(2, 4);

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8));

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10));

        packageType = hexTelegram.substring(10, 12); //01 for radio


        crcHeader = hexTelegram.substring(12, 14); //


        data = hexTelegram.substring(14, 14 + dataLength);

        subTelNum = Integer.parseInt(hexTelegram.substring(dataLength + 14, dataLength + 16), 16);

        destinationID = hexTelegram.substring(dataLength + 16, dataLength + 24);

        dbm = Integer.parseInt(hexTelegram.substring(dataLength + 24, dataLength + 26), 16);


        securityLevel = Integer.parseInt(hexTelegram.substring(dataLength + 26, dataLength + 28), 16);

        timeStamp = hexTelegram.substring(dataLength + 28, dataLength + 32);

        tickSubTel = hexTelegram.substring(dataLength + 32, dataLength + 34);

        dbmSubTel = hexTelegram.substring(dataLength + 34, dataLength + 36);

        statusSubTel = hexTelegram.substring(dataLength + 36, dataLength + 38);


        crcData = hexTelegram.substring(dataLength + 38, dataLength + 40); //

    }
}
