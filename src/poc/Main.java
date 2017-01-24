package poc;


/**
 * Created by silas on 07.10.16.
 */
public class Main {


    public static void main(String[] args) {


        /*

        print(bin(0x 55 (sync)  00 07 (Data length)   07(optional data lentgh )    01 (package type)  7a (checksum)   f6700022a13430 (data)   01ffffffff2d00  (optional data)  44 (checksum)
         */
        parseTelegram("0x55000707017af6700022a1343001ffffffff2d0044");


        // connectDevice();


    }


    public static int[] parseTelegram(String message) {
        /*
        |Position|Value|
        |---|---|
        |0|sync|
        |1|data_length|
        |2|optional_data_length|
        |3|package_type|
        |4|checksum|
        |5|data|
        |6|optional_data|
        |7|checksum|

         */

        int[] result = new int[8];
        byte[] header = new byte[4];

        int latestPosition = 0;

        result[0] = Integer.parseInt(message.substring(2, 4), 16);

        System.out.println(result[0]);


        result[1] = Integer.parseInt(message.substring(4, 8), 16);


        //header data length

        System.out.println(result[1]);
        result[2] = Integer.parseInt(message.substring(8, 10), 16);

        System.out.println(result[2]);
        result[3] = Integer.parseInt(message.substring(10, 12), 16);

        System.out.println(result[3]);

        //checksumbit

        result[4] = Integer.parseInt(message.substring(10, 12), 16);


        System.out.println(result[4]);

        result[5] = Integer.parseInt(message.substring(12, 12));


        return result;
    }

}
