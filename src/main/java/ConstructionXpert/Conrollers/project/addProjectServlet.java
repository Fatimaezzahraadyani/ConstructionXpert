package ConstructionXpert.Conrollers.project;

import ConstructionXpert.Model.Projet;
import ConstructionXpert.dao.ConnectToDb;
import ConstructionXpert.dao.ProjetDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addProject")
public class addProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ConnectToDb connectToDb = new ConnectToDb();
        connectToDb.getConnection();

        RequestDispatcher rs = request.getRequestDispatcher("view/home.jsp");
        rs.forward(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{

        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date dateDebut = Date.valueOf(request.getParameter("dateDebut"));
        Date dateFin = Date.valueOf(request.getParameter("dateFin"));
        String budgets = request.getParameter("budget");
        double budget = Double.valueOf(budgets);


        Projet projet = new Projet();

        projet.setNom(nom);
        projet.setDescription(description);
        projet.setDateDebut(dateDebut);
        projet.setDateFin(dateFin);
        projet.setBudget(budget);

        try {

        }
    }



}
