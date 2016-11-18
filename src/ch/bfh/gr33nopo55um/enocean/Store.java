package ch.bfh.gr33nopo55um.enocean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by silas on 18.11.16.
 */
public class Store {


    public static class Main {
        private static final String PERSISTENCE_UNIT_NAME = "todos";
        private static EntityManagerFactory factory;

        public static void main(String[] args) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            // read the existing entries and write to console
            Query q = em.createQuery("select t from Radio t");
            em.persist(q);
            em.getTransaction().commit();

            em.close();
        }

    }
}
