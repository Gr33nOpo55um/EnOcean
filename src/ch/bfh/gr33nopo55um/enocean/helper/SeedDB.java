package ch.bfh.gr33nopo55um.enocean.helper;

/**
 * Created by silas on 25.11.16.
 */
public class SeedDB {

    private static SeedDB instance;
    private boolean seedDone = false;

    private SeedDB() {
        // singelton
        seedDB();
    }

    public static SeedDB getInstance() {
        if (instance == null) {
            instance = new SeedDB();
        }
        return instance;
    }

    public void seedDB() {


//        Query query = Store.getInstance().createQuery("Select * from dual");


    }

    public boolean seedStatus() {
        return seedDone;
    }


}
