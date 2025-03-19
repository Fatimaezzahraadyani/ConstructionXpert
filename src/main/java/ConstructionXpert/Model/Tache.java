package ConstructionXpert.Model;

public class Tache {
    private int idTache;
    private String descriptionTache;
    private String dateDebutTache;
    private String dateFin;
    private int projetId;


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

    public String getDateDebutTache() {
        return dateDebutTache;
    }

    public void setDateDebutTache(String dateDebutTache) {
        this.dateDebutTache = dateDebutTache;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    public Tache(int idTache, String descriptionTache, String dateDebutTache, String dateFin, int projetId) {
        this.idTache = idTache;
        this.descriptionTache = descriptionTache;
        this.dateDebutTache = dateDebutTache;
        this.dateFin = dateFin;
        this.projetId = projetId;


    }
}
