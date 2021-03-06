package ch.bfh.gr33nopo55um.enocean.telegram;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author silas
 * @class ERP1 radio telegram, for further informations check EnoceanSerialProtocol v3. This is usually the default telegram type.
 **/
@Entity
public class RadioERP1 extends TelegramHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int subTelNum;
    private String destinationID;
    private int dbm;
    private int securityLevel;


    /**
     * @return telegram hex
     * @brief encodeTelegram provides an example telegram hex for this packet type.
     */
    @Override
    public String encodeTelegram() {
        return null;
    }

    /**
     * @return String hexTelegramData EnOcean Telegram
     * @brief encodeTelegramData provides an example data hex for this packet type.
     */
    @Override
    public String encodeTelegramData() {
        return null;
    }

    public int getSubTelNum() {
        return subTelNum;
    }

    private void setSubTelNum(int subTelNum) {
        this.subTelNum = subTelNum;
    }

    public String getDestinationID() {
        return destinationID;
    }

    private void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }

    public int getDbm() {
        return dbm;
    }

    private void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    private void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * @param hexTelegram in hex String
     * @brief decodeTelegramData splits telegram in parts
     */
    @Override
    public void decodeTelegramData(String hexTelegram) {


        //start of data
        int endOfDataLength = 14 + dataLength;


        this.setData(Long.parseLong(hexTelegram.substring(14, endOfDataLength), 16));
        this.setSubTelNum(Integer.parseInt(hexTelegram.substring(endOfDataLength, endOfDataLength + 2), 16));
        this.setDestinationID(hexTelegram.substring(endOfDataLength + 2, endOfDataLength + 10));
        this.setDbm(Integer.parseInt(hexTelegram.substring(endOfDataLength + 10, endOfDataLength + 12), 16));
        this.setSecurityLevel(Integer.parseInt(hexTelegram.substring(endOfDataLength + 12, endOfDataLength + 14), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(endOfDataLength + 14, endOfDataLength + 16), 16));


    }

    public void dumpData() {

        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        return "PacketType=RadioERP1" +
                " SubTelNum=" + subTelNum +
                " DestinationID=" + destinationID +
                " dBm=" + dbm +
                " SecurityLevel=" + securityLevel;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
