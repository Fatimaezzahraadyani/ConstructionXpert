package ConstructionXpert.Conrollers.project;

import ConstructionXpert.Model.Projet;
import ConstructionXpert.dao.ConnectToDb;
import ConstructionXpert.dao.ProjetDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;


@WebServlet("/UpdateProject")
public class UpdateProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

        ProjetDao projetDao;
    public void init (){
        projetDao = new ProjetDao();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConnectToDb connectToDb = new ConnectToDb();
        connectToDb.getConnection();

        int projetId = Integer.parseInt(request.getParameter("id"));
        Projet projet = projetDao.getProjectbyId(projetId);

        if (projet != null) {
            request.setAttribute("projet", projet);
            request.getRequestDispatcher("view/editProject.jsp").forward(request, response);
        } else {
            response.sendRedirect("view/Project.jsp?error=notfound");
        }
    }

    //prend les informations du formulaire et les met à jour dans la base de données

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try{

        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String dateDebut = request.getParameter("date_debut");
        String dateFin = request.getParameter("date_fin");
        double budget = Double.parseDouble(request.getParameter("budget"));

        Projet projet = new Projet(id, nom, description, dateDebut, dateFin, budget);

        //ProjetDao projetDao = new ProjetDao();
        projetDao.editProjet(projet);

        response.sendRedirect("view/Project.jsp?success=update");

    }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("editProject.jsp?error=1");
        }
    }

}
