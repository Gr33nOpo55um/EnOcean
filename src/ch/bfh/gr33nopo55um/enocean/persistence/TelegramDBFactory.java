package ch.bfh.gr33nopo55um.enocean.persistence;

import ch.bfh.gr33nopo55um.enocean.telegram.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author silas
 * @class Logic to determine which packettype should be persisted.
 **/
public class TelegramDBFactory {

    private static Logger logger = LogManager.getLogger();

    /**
     * @param hexTelegram in hex String
     * @return TelegramObject
     */
    public TelegramHeader telegramRouter(String hexTelegram) {


        /** @brief
         * 0           Reserved
         * 1           RADIO_ERP1 Radio802 telegram
         * 2           Response to any packet
         * 3           Radio802 subtelegram
         * 4           Event message
         * 5           Common command
         * 6           Smart Ack command
         * 7           Remote management command
         * 8           Reserved for EnOcean
         * 9           Radio802 message
         * 10          ERP2 protocol radio telegram
         * 11-15       Reserved for EnOcean
         * 16          802_15_4_RAW Packet
         * 17          2.4 GHz Command
         * 18 - 127    Reserved for EnOcean
         * 128...255   available MSC and messages
         */


        TelegramHeader telegram;


        /**
         * @brief Logic to determine further persistance way.
         */
        if (Integer.parseInt(hexTelegram.substring(2, 4), 16) == 85) {


            switch
                    (Integer.parseInt(hexTelegram.substring(10, 12), 16)) {


                case 1:
                    telegram = new RadioERP1();

                    break;
                case 2:
                    telegram = new Response();
                    break;

                case 3:
                    telegram = new Radio802();
                    break;

                case 4:
                    telegram = new Event();
                    break;

                case 5:
                    telegram = new CommonCommand();

                    break;
                case 6:
                    telegram = new SmartAckCommand();
                    break;

                case 7:
                    telegram = new SmartAckCommand();

                    break;
                case 9:
                    telegram = new Radio802();

                    break;
                case 10:
                    telegram = new RadioERP2();

                    break;

                default:
                    telegram = new Dummy();
                    break;
            }

            telegram.decodeTelegramHeader(hexTelegram);
            telegram.decodeTelegramData(hexTelegram);
            telegram.persist();

            logger.info("EnOcean Telegram: HEX=" + hexTelegram + " " + telegram.toString());

            return telegram;
        } else {
            /**
             * @brief No known telegram type found.

             */

            logger.warn("Wrong Telegram Sync byte! Taking dummy instead");
            telegram = new Dummy();

            return telegram;
        }
    }
}
