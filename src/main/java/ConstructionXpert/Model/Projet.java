package ConstructionXpert.Model;

import java.util.Date;

public class Projet {
    private int id;
    private String nom;
    private String description;
    private Date dateDebut ;
    private Date dateFin;
    private Double budget;

    public Projet(int id, String nom, String description, Date dateDebut, Date dateFin, Double budget) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }

    public Projet(String nom, String description, Date dateDebut, Date dateFin, Double budget) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }
}

