<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="ConstructionXpert.Model.Projet" %>
<%@ page import="ConstructionXpert.dao.ProjetDao" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>

<%
    int projetId = Integer.parseInt(request.getParameter("id"));
    ProjetDao projetDao = new ProjetDao();
    Projet projet = projetDao.getProjectbyId(projetId);
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier Projet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

    <div class="container mt-4">
        <h2 class="text-center text-primary mb-4">Modifier le Projet</h2>

        <form action="/ConstructionXpert/UpdateProject" method="post">
            <input type="hidden" name="id" value="<%= projet.getId() %>" />
            <label for="nom">Nom :</label>
            <input type="text" name="nom" value="<%= projet.getNom() %>" />

            <label for="description">Description :</label>
            <textarea name="description"> value="<%= projet.getDescription() %>"</textarea>

            <label for="dateDebut">Date de début :</label>
            <input type="text" name="date_debut" value="<%= projet.getDateDebut() %>" />

            <label for="dateFin">Date de fin :</label>
            <input type="text" name="date_fin" value="<%= projet.getDateFin() %>" />

            <label for="budget">Budget :</label>
            <input type="number" name="budget" value="<%= projet.getBudget() %>" />

            <button type="submit">Mettre à jour le projet</button>
        </form>

    </div>

</body>
</html>
