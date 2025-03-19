<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ConstructionXpert.Model.Projet" %>
<html>
<head>
    <title>Liste des Projets</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Liste des Projets</h2>

        <table class="table table-striped table-hover shadow">

            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Date Début</th>
                    <th>Date Fin</th>
                    <th>Budget</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Projet> projets = (List<Projet>) request.getAttribute("projets");
                    if (projets != null && !projets.isEmpty()) {
                        for (Projet projet : projets) {
                %>
                <tr>
                    <td><%= projet.getId() %></td>
                    <td><%= projet.getNom() %></td>
                    <td><%= projet.getDescription() %></td>
                    <td><%= projet.getDateDebut() %></td>
                    <td><%= projet.getDateFin() %></td>
                    <td><%= projet.getBudget() %> €</td>
                    <td>
                        <a href="UpdateProject?id=<%= projet.getId() %>" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i> Modifier
                        </a>
                        <a href="#" class="btn btn-danger btn-sm" onclick="confirmDelete(<%= projet.getId() %>)">
                            <i class="fas fa-trash"></i> Supprimer
                        </a>

                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="7" class="text-center">Aucun projet trouvé.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <a href="addProject" class="btn btn-primary" >Ajouter un Projet</a>
    </div>
    <script>
        function confirmDelete(projectId) {
            if (confirm("Voulez-vous vraiment supprimer ce projet ? Cette action est irréversible.")) {
                window.location.href = "DeleteProject?id=" + projectId;
            }
        }
    </script>

</body>
</html>
