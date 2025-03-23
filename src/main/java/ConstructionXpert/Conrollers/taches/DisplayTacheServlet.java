package ConstructionXpert.Conrollers.taches;

import ConstructionXpert.Model.Projet;
import ConstructionXpert.Model.Tache;
import ConstructionXpert.dao.ProjetDao;
import ConstructionXpert.dao.TacheDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/TachesProjet")
public class DisplayTacheServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TacheDao tacheDao = new TacheDao();
    private ProjetDao projetDao = new ProjetDao();

    public void init(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try {
            // Récupérer l'ID du projet depuis la requête
            String projetIdStr = request.getParameter("id");

            if (projetIdStr == null || projetIdStr.isEmpty()) {
                System.out.println("Erreur : ID du projet est manquant !");
                response.sendRedirect("Project.jsp?error=missingId");
            return;
            }

            //recuperer l' id du projet
            int projetId = Integer.parseInt(projetIdStr);

            //recuperer les taches associées au projet
            List<Tache> taches = tacheDao.getTacheByProjet(projetId);

            // Récupérer le nom du projet
            Projet projet = projetDao.getProjectbyId(projetId);
            String nom = projet != null ? projet.getNom() : "Projet inconnu";

            // Vérifier si la liste de tâches est vide
            if (taches == null) {
                System.out.println("Erreur : Aucune tâche trouvée pour le projet ID = " + projetId);
                response.sendRedirect("AllProject?error=noTaches");
                return;
            }
            // Ajouter la liste des tâches en attribut pour l'affichage
            request.setAttribute("taches", taches);
            request.setAttribute("projetId", projetId);

            // Rediriger vers la JSP qui affichera les tâches
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/TachesProject.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Page d'erreur si un problème survient
        }


        }

}
