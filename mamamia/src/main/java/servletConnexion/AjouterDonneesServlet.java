package servletConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connexion.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AjouterDonneesServlet")
public class  AjouterDonneesServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String nom = request.getParameter("nom");
            //String description = request.getParameter("description");
            double prix = Double.parseDouble(request.getParameter("prix"));

            ajouterPizza(connection, nom, prix);

            response.sendRedirect("afficher.jsp"); // Redirection vers la page d'affichage
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("erreur.jsp"); // Page d'erreur
        }
    }

    private void ajouterPizza(Connection connection, String nom, double prix) throws SQLException {
        String sql = "INSERT INTO Pizza (nom_pizza, prix) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nom);
            //preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, prix);
            preparedStatement.executeUpdate();
        }
    }
}
