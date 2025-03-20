package ConstructionXpert.Conrollers.taches;

import ConstructionXpert.Model.Tache;
import ConstructionXpert.dao.ProjetDao;
import ConstructionXpert.dao.TacheDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteTache")

public class DeleteTacheServlet extends HttpServlet {

    private TacheDao tacheDao;

    public void init(){
         tacheDao = new TacheDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            try {

                int id = Integer.parseInt(request.getParameter("id"));
                tacheDao.DeleteTache(id);
                response.sendRedirect("AllProject"); // Redirection après suppression
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("Project.jsp?deleteError=1");
            }


        }
    }

