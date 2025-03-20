package ConstructionXpert.Conrollers.project;

import ConstructionXpert.dao.ProjetDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteProject")
public class DeleteProjectServlet extends HttpServlet {

    ProjetDao projetDao;

    public void init(){

        projetDao = new ProjetDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try {

            int id = Integer.parseInt(request.getParameter("id"));
            projetDao.DeleteProject(id);
            response.sendRedirect("AllProject"); // Redirection après suppression
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Project.jsp?deleteError=1");
        }


    }
}
