package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @class ERP2 radio protocol telegram, for further informations check EnoceanSerialProtocol v3
 *
 * @author silas & louis
 */
@Entity
public class RadioERP2 extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private int subTelNum;
    private int dbm;
    private String rawData;


    /**
     * @brief encodeTelegram provides an example telegram hex for this packet type.
     *
     * @return telegram hex
     */
    @Override
    public String encodeTelegram() {
        return null;
    }

    /**
     * @brief encodeTelegramData provides an example data hex for this packet type.
     *
     * @return String hexTelegramData EnOcean Telegram
     */
    @Override
    public String encodeTelegramData() {
        return null;
    }

    /**
     * @brief decodeTelegramData splits telegram in parts
     *
     * @param hexTelegram in hex String
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {

        this.setRawData(hexTelegram.substring(14, 26));
        this.setSubTelNum(Integer.parseInt(hexTelegram.substring(26, 28), 16));
        this.setDbm(Integer.parseInt(hexTelegram.substring(28, 30), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(30, 32), 16));

    }

    /**
     *
     * @return subTelNum
     */
    public int getSubTelNum() {
        return subTelNum;
    }

    private void setSubTelNum(int subTelNum) {
        this.subTelNum = subTelNum;
    }

    public int getDbm() {
        return dbm;
    }

    private void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public String getRawData() {
        return rawData;
    }

    private void setRawData(String rawData) {
        this.rawData = rawData;
    }


    @Override
    public void dumpData() {
        System.out.println(this.toString());


    }

    @Override
    public String toString() {
        return "PacketType=RadioERP2" +
                " SubTelNum=" + subTelNum +
                " dBm=" + dbm +
                " RawData=" + rawData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
