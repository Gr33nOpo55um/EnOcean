package ch.bfh.gr33nopo55um.enocean.telegram;

/*
  Created by silas on 18.11.16.
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class SmartAckCommand extends TelegramHeader {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int smartAckCommandNr;
    private int smartAckCommandData;

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

        syncByte = Integer.parseInt(hexTelegram.substring(2, 4), 16); //55

        dataLength = Integer.parseInt(hexTelegram.substring(4, 8), 16); //7

        optionalLenght = Integer.parseInt(hexTelegram.substring(8, 10), 16); //7


        crcData = Integer.parseInt(hexTelegram.substring(12, 14), 16); //


    }

    /**
     * dumpData Print Data, useful for logs and testiing
     * <p>
     * EnOcean Telegram
     */
    @Override
    public void dumpData() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "SmartAckCommand{" +
                "smartAckCommandNr=" + smartAckCommandNr +
                ", smartAckCommandData=" + smartAckCommandData +
                '}';
    }

    public int getSmartAckCommandNr() {
        return smartAckCommandNr;
    }

    public void setSmartAckCommandNr(int smartAckCommandNr) {
        this.smartAckCommandNr = smartAckCommandNr;
    }

    public int getSmartAckCommandData() {
        return smartAckCommandData;
    }

    public void setSmartAckCommandData(int smartAckCommandData) {
        this.smartAckCommandData = smartAckCommandData;
    }
}
