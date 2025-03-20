<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ConstructionXpert.Model.Tache" %>
<%@ page import="ConstructionXpert.dao.TacheDao" %>
<%@ page import="ConstructionXpert.dao.ProjetDao" %>



<html>
<head>
    <title>Tâches du Projet</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Tâches associées au projet</h2>

        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Date Début</th>
                    <th>Date Fin</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Récupération des tâches associées au projet
                    List<Tache> taches = (List<Tache>) request.getAttribute("taches");

                    if (taches != null && !taches.isEmpty()) {
                        for (Tache tache : taches) {
                %>
                <tr>
                    <td><%= tache.getIdTache() %></td>
                    <td><%= tache.getDescriptionTache() %></td>
                    <td><%= tache.getDateDebutTache() %></td>
                    <td><%= tache.getDateFinTache() %></td>
                    <td>
                        <!-- Lien pour modifier une tâche -->
                        <a href="UpdateTache?id=<%= tache.getIdTache() %>" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i> Modifier
                        </a>

                        <!-- Lien pour supprimer une tâche avec confirmation -->
                        <a href="#" class="btn btn-danger btn-sm" onclick="confirmDelete(<%= tache.getIdTache() %>)">
                            <i class="fas fa-trash"></i> Supprimer
                        </a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" class="text-center">Aucune tâche trouvée pour ce projet.</td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <!-- Lien pour ajouter une tâche au projet -->
        <a href="AddTache?projetId=<%= request.getAttribute("projetId") %>" class="btn btn-primary">Ajouter une Tâche</a>
    </div>

    <script>
        // Fonction pour confirmer la suppression d'une tâche
        function confirmDelete(tacheId) {
            if (confirm("Êtes-vous sûr de vouloir supprimer cette tâche ?")) {
                window.location.href = "DeleteTache?id=" + tacheId;
            }
        }
    </script>
</body>
</html>
