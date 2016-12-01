package ch.bfh.gr33nopo55um.enocean.persistence;

import ch.bfh.gr33nopo55um.enocean.helper.SeedDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * Created by silas on 18.11.16.
 */
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
