package ConstructionXpert.Conrollers.taches;

import ConstructionXpert.Model.Tache;
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

    public void init(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        try {
            //recuperer l' id du projet
            int projetId = Integer.parseInt(request.getParameter("id"));

            //recuperer les taches associées au projet
            List<Tache> taches = tacheDao.getTacheByProjet(projetId);

            // Ajouter la liste des tâches en attribut pour l'affichage
            request.setAttribute("taches", taches);
            request.setAttribute("projetId", projetId);

            // Rediriger vers la JSP qui affichera les tâches
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/TachesProject.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Page d'erreur si un problème survient
        }


        }

        }


