<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil - Gestion de Construction</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="" action="/ConstructionXpert">Gestion de Construction</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="projets.jsp">Projets</a></li>
                    <li class="nav-item"><a class="nav-link" href="taches.jsp">Tâches</a></li>
                    <li class="nav-item"><a class="nav-link" href="ressources.jsp">Ressources</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenu principal -->
    <div class="container text-center mt-5">
        <h1>Bienvenue sur la plateforme de gestion de projets de construction</h1>
        <p class="lead">Gérez vos projets, tâches et ressources en toute simplicité.</p>

        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Projets</h5>
                        <p class="card-text">Créer et gérer vos projets.</p>
                        <a href="projets.jsp" class="btn btn-primary">Accéder</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Tâches</h5>
                        <p class="card-text">Attribuez des tâches à vos projets.</p>
                        <a href="taches.jsp" class="btn btn-primary">Accéder</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ressources</h5>
                        <p class="card-text">Gérez les ressources nécessaires.</p>
                        <a href="ressources.jsp" class="btn btn-primary">Accéder</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Pied de page -->
    <footer class="text-center mt-5 p-3 bg-light">
        <p>&copy; 2025 Gestion de Construction</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
