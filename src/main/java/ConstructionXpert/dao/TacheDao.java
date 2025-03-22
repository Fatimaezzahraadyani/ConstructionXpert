package ConstructionXpert.dao;

import ConstructionXpert.Model.Projet;
import ConstructionXpert.Model.Tache;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TacheDao extends ConnectToDb {
    private static final String ADD_TACHE = "INSERT INTO taches (descriptionTache, dateDebutTache, dateFinTache, projet_id) VALUES (?, ?, ?, ?)";
    private static final String GET_TACHES_BY_PROJET ="SELECT * FROM taches WHERE projetId = ?";
    private static final String GET_TACHE_BY_ID = "SELECT * FROM taches WHERE idTache = ?";
    private static final String UPDATE_TACHE ="UPDATE taches SET descriptionTache = ?, dateDebutTache = ?, dateFinTache = ? WHERE idTache = ?";
    private static final String DELETE_TACHE_BY_ID  = "DELETE FROM taches WHERE idTache = ?";


    public void addTache(Tache tache) {
        try(
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_TACHE)
        ) {
            stmt.setString(1, tache.getDescriptionTache());
            stmt.setDate(2, Date.valueOf(tache.getDateDebutTache()));
            stmt.setDate(3,Date.valueOf(tache.getDateFinTache()));
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
                PreparedStatement stmt = con.prepareStatement(GET_TACHES_BY_PROJET)
        ){
            stmt.setInt(1,projetId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("idTache");
                String descriptionTache = rs.getString("descriptionTache");
                LocalDate dateDebutTache = LocalDate.parse(rs.getString("dateDebutTache"));
                LocalDate dateFinTache = LocalDate.parse(rs.getString("dateFinTache"));

                taches.add(new Tache(id,descriptionTache,dateDebutTache,dateFinTache,projetId));

                System.out.println("✔️ Tâche récupérée : ID = " + id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return taches;
    }


    public Tache getTachebyId(int idTache) {
        Tache tache = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_TACHE_BY_ID)
        ) {
            stmt.setInt(1, idTache);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("idTache");
                String descriptionTache = rs.getString("descriptionTache");
                LocalDate dateDebutTache = LocalDate.parse(rs.getString("dateDebutTache"));
                LocalDate dateFinTache = LocalDate.parse(rs.getString("dateFinTache"));
                int projetId = rs.getInt("projetId");

                // Créer un objet Tache avec les données récupérées

                tache = new Tache(id, descriptionTache, dateDebutTache, dateFinTache, projetId);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tache;
    }

    public void editTache(Tache tache) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(UPDATE_TACHE)
        ) {
            stmt.setString(2, tache.getDescriptionTache());
            stmt.setDate(3, Date.valueOf(tache.getDateDebutTache()));
            stmt.setDate(4, Date.valueOf(tache.getDateFinTache()));
            stmt.setInt(6, tache.getIdTache());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated > 0) {
                System.out.println("tache bien modifier");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void DeleteTache(int TacheId){
                try (
                        Connection con = getConnection();
                        PreparedStatement stmt = con.prepareStatement(DELETE_TACHE_BY_ID);
                ){
                    stmt.setInt(1, TacheId);
                    stmt.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
}

