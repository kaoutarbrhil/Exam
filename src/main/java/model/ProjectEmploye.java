package model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_employe")
public class ProjectEmploye {
    @ManyToOne
    @JoinColumn(name = "idEmploye")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "idProject")
    private Project project;

    private int implication;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
