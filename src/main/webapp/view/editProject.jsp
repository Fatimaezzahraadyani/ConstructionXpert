<%@ page import="ConstructionXpert.Model.Projet" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page language="java" %>

<%
    Projet projet = (Projet) request.getAttribute("projet");
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier Projet</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Modifier le Projet</h2>

        <form action="UpdateProject" method="post">
            <input type="hidden" name="id" value="<%= projet.getId() %>">

            <div class="mb-3">
                <label class="form-label">Nom du Projet :</label>
                <input type="text" name="nom" class="form-control" value="<%= projet.getNom() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Description :</label>
                <textarea name="description" class="form-control" rows="3" required><%= projet.getDescription() %></textarea>
            </div>

            <div class="mb-3">
                <label class="form-label">Date de Début :</label>
                <input type="date" name="dat_debut" class="form-control" value="<%= projet.getDateDebut() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Date de Fin :</label>
                <input type="date" name="date_fin" class="form-control" value="<%= projet.getDateFin() %>" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Budget :</label>
                <input type="number" step="0.01" name="budget" class="form-control" value="<%= projet.getBudget() %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <a href="Project.jsp" class="btn btn-secondary">Annuler</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
