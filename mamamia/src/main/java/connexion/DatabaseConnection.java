package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
    private static final String URL = "jdbc:mysql://localhost:8036/pizzainnodb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Erreur de connexion à la base de données", e);
        }catch (SQLException e) {
            throw new SQLException("Erreur de connexion à la base de données", e);
        }
    }

}
