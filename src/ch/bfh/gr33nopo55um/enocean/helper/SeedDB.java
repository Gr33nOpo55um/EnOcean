package ch.bfh.gr33nopo55um.enocean.helper;

/**
 * Created by silas on 25.11.16.
 */


public class SeedDB {

    private static SeedDB instance;

    private SeedDB() {
        // singelton
        insertCoreData();
    }

    /**
     * @return DBinstance
     */
    public static SeedDB getInstance() {
        if (instance == null) {
            instance = new SeedDB();
        }
        return instance;
    }

    /**
     * Is used to store core data in Database, e.g User, etc.
     */
    public void insertCoreData() {
        //not neccessary yet
    }


}
