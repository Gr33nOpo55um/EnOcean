package ch.bfh.gr33nopo55um.enocean.test;

import ch.bfh.gr33nopo55um.enocean.helper.ReadConfig;
import it.polito.elite.enocean.enj.link.EnJLink;
import it.polito.elite.enocean.protocol.serial.v3.network.packet.ESP3Packet;

import java.io.IOException;

/**
 * Used for Testing telegrams
 *
 * @author louis
 */
public class Sender {

    public static void main(String args[]) {

        ReadConfig readConfig = new ReadConfig();
        try {
            System.out.println(readConfig.readPropertyValue("serialPort"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        EnJLink linkLayer = null;
        try {
            linkLayer = new EnJLink(readConfig.readPropertyValue("serialPort")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        linkLayer.connect();

        /*
        * Loop for masssending 0x55 000a 07 01 eb a50000000c019134fc00 01 ffffffff 3d 00 2f
        */
        for (int i = 0; i < 10; i++) {
            byte packetType = (byte)1;
            byte[] data = new byte[] { (byte)0xa5, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0c, (byte)0x01, (byte)0x91, (byte)0x34, (byte)0xfc, (byte)0x00 };
            byte[] optData = new byte[] { (byte)0x01, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0x3d, (byte)0x00 };

            ESP3Packet esp3Packet = new ESP3Packet(packetType, data, optData);
            esp3Packet.buildPacket();
            linkLayer.send(esp3Packet);
        }

        /*
        * Loop for masssending 0x55 0007 07 01 7af6000022a13420 01 ffffffff 33 00 88
        */
        for (int i = 0; i < 10; i++) {
            byte packetType = (byte)1;
            byte[] data = new byte[] { (byte)0x7a, (byte)0xf6, (byte)0x00, (byte)0x00, (byte)0x22, (byte)0xa1, (byte)0x34, (byte)0x20 };
            byte[] optData = new byte[] { (byte)0x01, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0xff, (byte)0x33, (byte)0x00 };

            ESP3Packet esp3Packet = new ESP3Packet(packetType, data, optData);
            esp3Packet.buildPacket();
            linkLayer.send(esp3Packet);
        }
    }
}
