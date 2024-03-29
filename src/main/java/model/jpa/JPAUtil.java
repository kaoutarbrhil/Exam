package model.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String NOM_UNITE_PERSISTANCE = "PERSISTENCE";
    private static EntityManagerFactory usine;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (usine == null) {
            usine = Persistence.createEntityManagerFactory(NOM_UNITE_PERSISTANCE);
        }
        return usine;
    }

    public static void shutdown() {
        if (usine != null) {
            usine.close();
        }
    }
}
