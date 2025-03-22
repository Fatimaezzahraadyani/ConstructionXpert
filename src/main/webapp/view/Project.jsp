<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ConstructionXpert.Model.Projet" %>
<%@ page import="ConstructionXpert.dao.ProjetDao" %>

<html>
<head>
    <title>Liste des Projets</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        .card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            border-radius: 10px;
            overflow: hidden; /* Pour éviter que le contenu dépasse */
        }
        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }
        .card-body {
            padding: 15px;
        }
        /* Badge de statut */
        .badge-status {
            font-size: 0.9em;
            padding: 5px 10px;
            border-radius: 10px;
        }
        .badge-status.in-progress {
            background-color: #ffca28;
        }
        .badge-status.completed {
            background-color: #4caf50;
        }
        .badge-status.delayed {
            background-color: #f44336;
        }
        /* Responsive : pleine largeur sur mobile */
        @media (max-width: 768px) {
            .col-12 {
                padding-left: 0;
                padding-right: 0;
            }
            .card {
                width: 100%;
                margin: 0;
                border-radius: 5px;
            }
            .card-body {
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Liste des Projets</h2>

        <div class="row">
            <%
                // Récupération de la liste des projets depuis l'attribut 'projets'
                List<Projet> projets = (List<Projet>) request.getAttribute("projets");

                // Vérification si des projets existent
                if (projets != null && !projets.isEmpty()) {
                    for (Projet projet : projets) {
            %>

            <!-- Carte de projet avec des effets de survol -->
            <div class="col-12 col-sm-6 col-md-4 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><%= projet.getNom() %></h5>

                        <p class="card-text mt-2">
                            <strong>Description:</strong> <%= projet.getDescription() %> <br>
                            <strong>Date Début:</strong> <%= projet.getDateDebut() %> <br>
                            <strong>Date Fin:</strong> <%= projet.getDateFin() %> <br>
                        </p>

                        <!-- Actions -->
                        <a href="UpdateProject?id=<%= projet.getId() %>" class="btn btn-warning btn-sm">
                            <i class="fas fa-edit"></i> Modifier
                        </a>
                        <a href="#" class="btn btn-danger btn-sm" onclick="confirmDelete(<%= projet.getId() %>)">
                            <i class="fas fa-trash"></i> Supprimer
                        </a>
                        <a href="TachesProjet?id=<%= projet.getId() %>" class="btn btn-info btn-sm">
                            Voir les tâches
                        </a>
                    </div>
                </div>
            </div>

            <% } } else { %>
                <div class="col-12">
                    <p class="text-center">Aucun projet trouvé.</p>
                </div>
            <% } %>
        </div>

        <!-- Lien vers la page d'ajout d'un projet -->
        <a href="addProject" class="btn btn-primary mt-3">Ajouter un Projet</a>
    </div>

    <script>
        function confirmDelete(projetId) {
            if (confirm("Êtes-vous sûr de vouloir supprimer ce projet ?")) {
                window.location.href = "DeleteProject?id=" + projetId;
            }
        }
    </script>
</body>
</html>
