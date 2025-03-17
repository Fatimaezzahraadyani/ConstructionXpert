package ConstructionXpert.dao;

import ConstructionXpert.Model.Projet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjetDao extends ConnectToDb{
    private static final String ADD_PROJET = "insert into projets(nom,description,dateDebut,dateFin,budget) values (?,?,?,?,?);";


    public ProjetDao(){}

    public ProjetDao projetDao = new ProjetDao();

    public void addProject (Projet projet){
        try (
                Connection con = getConnection();
        PreparedStatement stmt = con.prepareStatement(ADD_PROJET);
        ){
            stmt.setString(1, projet.getNom());
            stmt.setString(2,projet.getDescription());
            stmt.setDate(3, (Date) projet.getDateDebut());
            stmt.setDate(4, (Date) projet.getDateFin());
            stmt.setDouble(5,projet.getBudget());


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
