package ch.bfh.gr33nopo55um.enocean.persistence;

import ch.bfh.gr33nopo55um.enocean.helper.SeedDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * Used for persisitency. Store class is implementet in telegram header.
 *
 * @author silas
 */
@SuppressWarnings("ALL")
public class Store {
    private static Store instance;
    private EntityManager entityManager = null;
    private String jpaStoreId = "store";

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();

            SeedDB.getInstance().seedDB();
        }
        return instance;
    }

    public Query createQuery(String query) {
        EntityManager manager = this.getEntityManager();
        return manager.createQuery(query);
    }


    public EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("store");
            entityManager = emfactory.createEntityManager();
        }
        return entityManager;
    }





}
