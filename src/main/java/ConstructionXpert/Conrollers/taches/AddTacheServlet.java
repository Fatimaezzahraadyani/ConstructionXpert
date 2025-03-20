package ConstructionXpert.Conrollers.taches;

import ConstructionXpert.Model.Tache;
import ConstructionXpert.dao.TacheDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/AddTache")
public class AddTacheServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TacheDao tacheDao = new TacheDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException , IOException {
        try {

            // Récupérer les paramètres
            int projetId = Integer.parseInt(request.getParameter("projetId"));
            String descriptionTache = request.getParameter("descriptionTache");
            String dateDebutTache = request.getParameter("dateDebutTache");
            String dateFinTache = request.getParameter("dateFinTache");


            // Créer l'objet Tache
            Tache tache = new Tache(0, descriptionTache, dateDebutTache, dateFinTache, projetId);
            tacheDao.addTache(tache);

            // Rediriger vers la page du projet
            response.sendRedirect("view/project.jsp?success=tacheAdded");

        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("AddTache.jsp?error=1");
        }
    }
}
