package controller;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import model.Employe;
import model.dao.EmployeDAO;

import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "employeBean")
@RequestScoped
public class EmployeBean {
    private Employe selectedEmploye;

    public Employe getSelectedEmploye() {
        return selectedEmploye;
    }

    public void setSelectedEmploye(Employe selectedEmploye) {
        this.selectedEmploye = selectedEmploye;
    }



    public String nouveau() {
        Employe e = new Employe();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("employe", e);
        return "/faces/list.xhtml";
    }

    public String enregistrer(Employe employe) {
        EmployeDAO employeDAO = new EmployeDAO();
        employeDAO.enregistrer(employe);
        return "/faces/list.xhtml";
    }

    public List<Employe> obtenirEmployes() {
        EmployeDAO employeDAO = new EmployeDAO();
        return employeDAO.obtenirEmployes();
    }




    // Supprimer un employé
    public String supprimer(Long id) {
        EmployeDAO employeDAO = new EmployeDAO();
        employeDAO.supprimer(id);
        System.out.println("Employé supprimé..");
        return "/faces/list.xhtml";
    }
}
