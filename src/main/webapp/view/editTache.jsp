<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="ConstructionXpert.Model.Tache" %>
<html>
<head>
    <title>Modifier une Tâche</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Modifier la Tâche</h2>

        <%
            // Récupérer la tâche depuis l attribut de requête
            Tache tache = (Tache) request.getAttribute("tache");
            if (tache != null) {
        %>
        <form action="UpdateProject" method="get" class="shadow p-4 bg-light rounded">
            <!-- Champ caché pour l'ID de la tâche -->
            <input type="hidden" name="id" value="<%= tache.getIdTache() %>" />

            <div class="mb-3">
                <label for="descriptionTache" class="form-label">Description de la tâche</label>
                <input type="text" class="form-control" id="descriptionTache" name="descriptionTache" value="<%= tache.getDescriptionTache() %>" required />
            </div>

            <div class="mb-3">
                <label for="dateDebutTache" class="form-label">Date de début</label>
                <input type="date" class="form-control" id="dateDebutTache" name="dateDebutTache" value="<%= tache.getDateDebutTache() %>" required />
            </div>

            <div class="mb-3">
                <label for="dateFinTache" class="form-label">Date de fin</label>
                <input type="date" class="form-control" id="dateFinTache" name="dateFinTache" value="<%= tache.getDateFinTache() %>" required />
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Enregistrer</button>
                <a href="TachesProjet?id=<%= tache.getProjetId() %>" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
        <%
            } else {
        %>
        <div class="alert alert-danger mt-4 text-center">Erreur : Tâche introuvable.</div>
        <%
            }
        %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
