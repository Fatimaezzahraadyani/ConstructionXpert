package ConstructionXpert.dao;

import ConstructionXpert.Model.Tache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacheDao extends ConnectToDb {
    private static final String ADD_TACHE = "INSERT INTO taches ((description, dateDebut, dateFin, projetId) VALUES (?, ?, ?, ?))";
    private static final String GET_TACHES_BY_PROJET ="SELECT * FROM taches where projetId = ?";
    public void addTache(Tache tache) {
        try(
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_TACHE)
        ) {
            stmt.setString(1, tache.getDescriptionTache());
            stmt.setString(2, tache.getDateDebutTache());
            stmt.setString(3,tache.getDateFin());
            stmt.setInt(4, tache.getProjetId());

            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Tache> getTacheByProjet(int projetId){
        List<Tache> taches = new ArrayList<>();

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_TACHE)
        ){
            stmt.setInt(1,projetId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String descriptionTache = rs.getString("descriptionTache");
                String dateDebutTache = rs.getString("dateDebuTache");
                String dateFinTache = rs.getString("dateFinTache");

                taches.add(new Tache(id,descriptionTache,dateDebutTache,dateFinTache,projetId));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return taches;
    }
}
