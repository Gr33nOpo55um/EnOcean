package ch.bfh.gr33nopo55um.enocean.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @class When sending a telegram, a RESPOND has to be expected. In this case, the following RESPONSE message gives the return codes: 00 RET_OK 02 RET_NOT_SUPPORTED 03 RET_WRONG_PARAM, for further informations check EnoceanSerialProtocol v3
 *
 * @author silas & louis
 */
@Entity
public class Response extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private int returnCode;

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

        this.setReturnCode(Integer.parseInt(hexTelegram.substring(14, 4), 16));
        this.setCrcData(Integer.parseInt(hexTelegram.substring(14, 16), 16));

    }

    /**
     * @brief dumpData Print Data, useful for logs and testiing
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "PacketType=Response" +
                " ReturnCode=" + returnCode;
    }

    public int getReturnCode() {
        return returnCode;
    }

    private void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
}

