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

@WebServlet("/UpdateTache")
public class UpdateTacheServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    TacheDao tacheDao;
    public void init (){
        tacheDao = new TacheDao();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConnectToDb connectToDb = new ConnectToDb();
        connectToDb.getConnection();
        //String idTacheStr = request.getParameter("idTache");

        /*if (idTacheStr == null || idTacheStr.isEmpty()) {
            System.out.println("Erreur : idTache est null ou vide !");
            response.sendRedirect("TachesProject.jsp?error=missingId");
            return;
        }*/
        try {

            int tacheId = Integer.parseInt(request.getParameter("id"));

            // Récupérer la tâche existante à partir de l'id
            Tache tache = tacheDao.getTachebyId(tacheId);

            // Mettre la tâche dans l'attribut de requête pour l'afficher dans le formulaire
            request.setAttribute("tache", tache);

            // Afficher la page de modification
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/editTache.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("view/Project.jsp?error=updateTache");
        }
    }

    //prend les informations du formulaire et les met à jour dans la base de données

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try{

            int TacheId = Integer.parseInt(request.getParameter("id"));

            String descriptionTache = request.getParameter("descriptionTache");
            LocalDate dateDebutTache = LocalDate.parse(request.getParameter("dateDebutTache"));
            LocalDate dateFinTache = LocalDate.parse(request.getParameter("dateFinTache"));


            Tache tache = new Tache(TacheId,  descriptionTache, dateDebutTache, dateFinTache);

            //ProjetDao projetDao = new ProjetDao();
            tacheDao.editTache(tache);

            response.sendRedirect("TachesProjet");

        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("view/editTache.jsp?error=1");
        }
    }

}