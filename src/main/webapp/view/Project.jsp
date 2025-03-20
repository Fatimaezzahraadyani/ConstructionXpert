<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ConstructionXpert.Model.Projet" %>
<%@ page import="ConstructionXpert.dao.ProjetDao" %>

<html>
<head>
    <title>Liste des Projets</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Liste des Projets</h2>

        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Date Début</th>
                    <th>Date Fin</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Récupération de la liste des projets depuis l'attribut 'projets'
                    List<Projet> projets = (List<Projet>) request.getAttribute("projets");

                    // Vérification si des projets existent
                    if (projets != null && !projets.isEmpty()) {
                        for (Projet projet : projets) {
                %>
                <tr>
                    <td><%= projet.getId() %></td>
                    <td><%= projet.getNom() %></td>
                    <td><%= projet.getDescription() %></td>
                    <td><%= projet.getDateDebut() %></td>
                    <td><%= projet.getDateFin() %></td>
                    <td>
                        <!-- Lien vers la page de modification du projet -->
                        <a href="UpdateProject?id=<%= projet.getId() %>" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i> Modifier
                        </a>

                        <!-- Lien pour supprimer un projet avec confirmation -->
                        <a href="#" class="btn btn-danger btn-sm" onclick="confirmDelete(<%= projet.getId() %>)">
                            <i class="fas fa-trash"></i> Supprimer
                        </a>

                        <!-- Lien vers la page des tâches associées au projet -->
                        <a href="TachesProjet?id=<%= projet.getId() %>" class="btn btn-info btn-sm">
                            Voir les tâches
                        </a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6" class="text-center">Aucun projet trouvé.</td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <!-- Lien vers la page d'ajout d'un projet -->
        <a href="addProject" class="btn btn-primary">Ajouter un Projet</a>
    </div>

    <script>
        // Fonction pour confirmer la suppression d'un projet
        function confirmDelete(projetId) {
            if (confirm("Êtes-vous sûr de vouloir supprimer ce projet ?")) {
                window.location.href = "DeleteProject?id=" + projetId;
            }
        }
    </script>
</body>
</html>
