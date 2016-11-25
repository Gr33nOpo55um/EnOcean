package ch.bfh.gr33nopo55um.enocean.helper;

import ch.bfh.gr33nopo55um.enocean.persistence.Store;

import javax.persistence.Query;

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

    private void seedDB() {


        Query query = Store.getInstance().createQuery("Select * from dual");


    }

    public static SeedDB getInstance() {
        if (instance == null) {
            instance = new SeedDB();
        }
        return instance;
    }

    public boolean seedStatus() {
        return seedDone;
    }






}
