package ConstructionXpert.dao;

import ConstructionXpert.Model.Projet;

import java.sql.*;

public class ProjetDao extends ConnectToDb {
    private static final String ADD_PROJET = "insert into projets(nom,description,dateDebut,dateFin,budget) values (?,?,?,?,?);";
    private static final String UPDATE_PROJET = "UPDATE projets SET nom = ?, description = ?, dateDebut = ?, dateFin = ?, budget = ? WHERE id = ?";
    private static final String GET_PROJET_BY_ID = "SELECT * FROM projets WHERE id = ?";


    public ProjetDao() {
    }


    public void addProjet(Projet projet) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_PROJET)
        ) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, projet.getDateDebut());
            stmt.setString(4, projet.getDateFin());
            stmt.setDouble(5, projet.getBudget());


            int rowsInserted = stmt.executeUpdate();
            ;
            if (rowsInserted > 0) {
                System.out.println("Projet inséré avec succès !");
            } else {
                System.out.println("Échec de l'insertion !");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editProjet(Projet projet) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(UPDATE_PROJET)
        ) {
            stmt.setString(1, projet.getNom());
            stmt.setString(2, projet.getDescription());
            stmt.setString(3, String.valueOf(projet.getDateDebut()));
            stmt.setString(4,String.valueOf(projet.getDateFin()));
            stmt.setDouble(5, projet.getBudget());

            int rowUpdated = stmt.executeUpdate();

            if(rowUpdated>0){
                System.out.println("projet bien modifier");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Projet getProjectbyId (int projetId) {
        Projet projet = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_PROJET_BY_ID)
        ) {
            stmt.setInt(1, projetId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                String dateDebut = rs.getString("date_debut");
                String dateFin = rs.getString("date_fin");
                double budget = Double.parseDouble(rs.getString("budget"));

                projet = new Projet(id, nom, description, dateDebut, dateFin, budget);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return projet;
    }
}