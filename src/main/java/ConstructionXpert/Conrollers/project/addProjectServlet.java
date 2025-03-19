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

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addProject")
public class addProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private ProjetDao projetDao = null;

    public void init(){
        projetDao = new ProjetDao();
        //System.out.println("Servlet addProjectServlet initialisée !");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ConnectToDb connectToDb = new ConnectToDb();
        connectToDb.getConnection();

        RequestDispatcher rs = request.getRequestDispatcher("/view/AddProject.jsp");
        rs.forward(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException {

        try {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("date_debut");
            String dateFin = request.getParameter("date_fin");
            double budget = Double.parseDouble(request.getParameter("budget"));

            Projet projet = new Projet(nom, description, dateDebut, dateFin, budget);

            projetDao.addProjet(projet); //insérer les données

            response.sendRedirect("Project.jsp?success=1");

        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("AddProject.jsp?error=1");

        }
    }

}
