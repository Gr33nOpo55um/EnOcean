package ch.bfh.gr33nopo55um.enocean.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * @author silas
 * @class Used for persisitency. Store class is implementet in telegram header.
 */
@SuppressWarnings("ALL")
public class Store {


    private static Store instance;
    private EntityManager entityManager = null;
    private String jpaStoreId = "store";


    /**
     * @return DB Instance
     * @brief create a new Instance of a DB
     */
    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();

            SeedDB.getInstance().insertCoreData();
        }
        return instance;
    }

    /**
     * @param query if you want to make queries on your own. with advantage use predefined queries ;)
     * @return runnable query
     */
    public Query createQuery(String query) {
        EntityManager manager = this.getEntityManager();
        return manager.createQuery(query);
    }

    /**
     * @return entity manager
     * @brief create a enitityManager with the persistence.xml. Entity Manger is used for which class is relatet to each other...
     */
    public EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("store");
            entityManager = emfactory.createEntityManager();
        }
        return entityManager;
    }


}
