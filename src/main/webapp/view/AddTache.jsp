<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="ConstructionXpert.Model.Tache" %>
<%@ page import="ConstructionXpert.Model.Projet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.*" %>
<%@ page import="ConstructionXpert.dao.TacheDao" %>
<%@ page import="ConstructionXpert.dao.ProjetDao" %>
<html>
<head>
    <title>Ajouter une Tâche</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Ajouter une nouvelle tâche</h2>

        <form action="AddTache" method="post">
            <!-- Le projet auquel la tâche appartient -->
            <div class="mb-3">
                <label for="projetId" class="form-label">Projet</label>
                <select name="projetId" class="form-control" required>
                    <option value="">-- Sélectionner un projet --</option>
                    <%
                        List<Projet> projets = (List<Projet>) request.getAttribute("projets");
                        if (projets != null && !projets.isEmpty()) {
                            for (Projet projet : projets) {
                    %>
                                <option value="<%= projet.getId() %>"><%= projet.getNom() %></option>
                    <%
                            }
                        } else {
                    %>
                        <option disabled>Aucun projet disponible</option>
                    <%
                        }
                    %>
                </select>

            </div>

            <!-- Description de la tâche -->
            <div class="mb-3">
                <label for="descriptionTache" class="form-label">Description de la tâche</label>
                <input type="text" class="form-control" name="descriptionTache" id="descriptionTache" required>
            </div>

            <!-- Date de début -->
            <div class="mb-3">
                <label for="dateDebutTache" class="form-label">Date de début</label>
                <input type="date" class="form-control" name="dateDebutTache" id="dateDebutTache" required>
            </div>

            <!-- Date de fin -->
            <div class="mb-3">
                <label for="dateFin" class="form-label">Date de fin</label>
                <input type="date" class="form-control" name="dateFinTache" id="dateFin" required>
            </div>

            <button type="submit" class="btn btn-primary">Ajouter la tâche</button>
        </form>
    </div>
</body>
</html>
