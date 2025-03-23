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

    public void init() {
        projetDao = new ProjetDao();
        //System.out.println("Servlet addProjectServlet initialisée !");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConnectToDb connectToDb = new ConnectToDb();
        connectToDb.getConnection();

        RequestDispatcher rs = request.getRequestDispatcher("/view/AddProject.jsp");
        rs.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            String dateDebut = request.getParameter("date_debut");
            String dateFin = request.getParameter("date_fin");
            double budget = Double.parseDouble(request.getParameter("budget"));

            // Validation des champs
            if (nom == null || nom.trim().isEmpty()) {
                request.setAttribute("error", "Le nom du projet est requis.");
                request.getRequestDispatcher("view/addProject.jsp").forward(request, response);
                return;
            }

            if (description == null || description.trim().isEmpty()) {
                request.setAttribute("error", "La description du projet est requise.");
                request.getRequestDispatcher("view/addProject.jsp").forward(request, response);
                return;
            }

            if (dateDebut == null || dateFin == null || dateDebut.isEmpty() || dateFin.isEmpty()) {
                request.setAttribute("error", "Les dates de début et de fin sont requises.");
                request.getRequestDispatcher("view/addProject.jsp").forward(request, response);
                return;
            }

            // Convertir les dates en objets LocalDate
            try {
                java.time.LocalDate dateDebuts = java.time.LocalDate.parse(dateDebut);
                java.time.LocalDate dateFins = java.time.LocalDate.parse(dateFin);

                // Vérifier si la date de début est avant la date de fin
                if (dateDebuts.isAfter(dateFins)) {
                    request.setAttribute("error", "La date de début doit être avant la date de fin.");
                    request.getRequestDispatcher("view/addProject.jsp").forward(request, response);
                    return;
                }


                Projet projet = new Projet(nom, description, dateDebut, dateFin, budget);

                projetDao.addProjet(projet); //insérer les données

                response.sendRedirect("AllProject?success=1");

            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("AddProject.jsp?error=1");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


