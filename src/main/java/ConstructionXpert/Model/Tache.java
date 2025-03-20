package ConstructionXpert.Model;

import java.time.LocalDate;

public class Tache {
    private int idTache;
    private String descriptionTache;
    private LocalDate dateDebutTache;
    private LocalDate dateFinTache;
    private int projetId;

    public Tache(int idTache, String descriptionTache, LocalDate dateDebutTache, LocalDate dateFinTache, int projetId) {
        this.idTache = idTache;
        this.descriptionTache = descriptionTache;
        this.dateDebutTache = dateDebutTache;
        this.dateFinTache = dateFinTache;
        this.projetId = projetId;
    }

    public Tache(int id, String descriptionTache, LocalDate dateDebutTache, LocalDate dateFinTache) {
    }

    public int getIdTache() {
        return idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public String getDescriptionTache() {
        return descriptionTache;
    }

    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }

    public LocalDate getDateDebutTache() {
        return dateDebutTache;
    }

    public void setDateDebutTache(LocalDate dateDebutTache) {
        this.dateDebutTache = dateDebutTache;
    }

    public LocalDate getDateFinTache() {
        return dateFinTache;
    }

    public void setDateFinTache(LocalDate dateFin) {
        this.dateFinTache = dateFin;
    }

    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }
}
