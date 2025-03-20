package ConstructionXpert.Conrollers.taches;

import ConstructionXpert.Model.Projet;
import ConstructionXpert.Model.Tache;
import ConstructionXpert.dao.ConnectToDb;
import ConstructionXpert.dao.ProjetDao;
import ConstructionXpert.dao.TacheDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet("/AddTache")
public class AddTacheServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TacheDao tacheDao = new TacheDao();

    private ProjetDao projetDao = new ProjetDao();


    public void init(){

        System.out.println("AddTacheServlet initialisée !");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer la liste des projets
            List<Projet> projets = projetDao.getAllProjects();
            request.setAttribute("projets", projets);
            System.out.println("Liste des projets récupérée : " + projets.size());

            // Affichage du formulaire d'ajout de tâche
            RequestDispatcher rs = request.getRequestDispatcher("/view/AddTache.jsp");
            rs.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("view/Project.jsp?error=loadProjects");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException , IOException {
        try {

            // Récupérer les paramètres
            int projetId = Integer.parseInt(request.getParameter("projetId"));
            String descriptionTache = request.getParameter("descriptionTache");
            LocalDate dateDebutTache = LocalDate.parse(request.getParameter("dateDebutTache"));
            LocalDate dateFinTache = LocalDate.parse(request.getParameter("dateFinTache"));


            // Créer l'objet Tache
            Tache tache = new Tache(0, descriptionTache, dateDebutTache, dateFinTache, projetId);
            tacheDao.addTache(tache);

            // Rediriger vers la page du projet
            response.sendRedirect("AllProject?success=tacheAdded");

        }catch (Exception e){
            e.printStackTrace();

            System.out.println("Erreur de l'ajout");

            response.sendRedirect("AddTache.jsp?error=1");
        }
    }
}
