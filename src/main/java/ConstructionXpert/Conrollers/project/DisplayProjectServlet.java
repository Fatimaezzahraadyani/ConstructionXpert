package ConstructionXpert.Conrollers.project;

import ConstructionXpert.Model.Projet;
import ConstructionXpert.dao.ProjetDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/AllProject")
public class DisplayProjectServlet extends HttpServlet {

    ProjetDao projetDao = null;

    public void init(){

     projetDao = new ProjetDao();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException , IOException{
        List<Projet> projets = projetDao.getAllProjects();

        if(projets == null || projets.isEmpty()){
            System.out.println("Aucun projet trouvé dans la base de donées");
        }else {
            System.out.println("Nombre de projets trouvés: " + projets.size());
        }

        request.setAttribute("projets", projets);
        RequestDispatcher rs = request.getRequestDispatcher("view/Project.jsp");
        rs.forward(request, response);

    }


}
