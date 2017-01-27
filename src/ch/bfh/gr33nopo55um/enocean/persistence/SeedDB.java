package ch.bfh.gr33nopo55um.enocean.persistence;

/**
 * @class DB seed and inital gnerating
 *
 * @author silas
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
     * @brief Is used to store core data in Database, e.g User, etc.
     */
    public void insertCoreData() {
        //not neccessary yet
    }


}
