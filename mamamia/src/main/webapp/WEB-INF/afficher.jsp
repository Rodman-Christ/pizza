<!-- WebContent/afficher.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="connexion.Pizza" %>
<%@ page import="connexion.DatabaseConnection" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Pizzas</title>
</head>
<body>
    <h2>Liste des Pizzas</h2>
    <% List<Pizza> pizzas = recupererPizzas(); %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
        </tr>
        <% for (Pizza pizza : pizzas) { %>
            <tr>
                <td><%= pizza.getIdPizza() %></td>
                <td><%= pizza.getNomPizza() %></td>
                <td><%= pizza.getPrix() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>

<%! List<Pizza> recupererPizzas() throws SQLException {
    List<Pizza> pizzas = new ArrayList<>();
    try (Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Pizza")) {
        while (resultSet.next()) {
            Pizza pizza = new Pizza();
            pizza.setIdPizza(resultSet.getInt("pizzaId"));
            pizza.setNomPizza(resultSet.getString("nom_pizza"));
            pizza.setPrix(resultSet.getDouble("prix"));
            pizzas.add(pizza);
        }
    }
    return pizzas;
} %>
