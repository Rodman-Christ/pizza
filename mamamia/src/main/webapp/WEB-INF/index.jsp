<!-- WebContent/index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Pizza</title>
</head>
<body>
    <h2>Ajouter une Pizza</h2>
    <form action="AjouterPizzaServlet" method="post">
        Nom: <input type="text" name="nom" required><br>
        Description: <input type="text" name="description"><br>
        Prix: <input type="text" name="prix" required><br>
        <input type="submit" value="Ajouter Pizza">
    </form>
</body>
</html>
