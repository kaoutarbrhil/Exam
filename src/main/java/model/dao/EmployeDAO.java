package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Employe;
import model.jpa.JPAUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeDAO {

    private EntityManager entite = JPAUtil.getEntityManagerFactory().createEntityManager();

    // Enregistrer l'employé
    public void enregistrer(Employe employe) {
        entite.getTransaction().begin();
        entite.persist(employe);
        entite.getTransaction().commit();
    }

    // Supprimer l'employé par ID
    public void supprimer(Long id) {
        Employe e = entite.find(Employe.class, id);
        if (e != null) {
            entite.getTransaction().begin();
            entite.remove(e);
            entite.getTransaction().commit();
        }
    }

    // Obtenir tous les employés
    public List<Employe> obtenirEmployes() {
        List<Employe> listeEmployes = new ArrayList<>();
        Query query = entite.createQuery("SELECT e FROM Employe e");
        listeEmployes = query.getResultList();
        return listeEmployes;
    }
}

