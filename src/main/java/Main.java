import rachni.masqueradb.UIConsole.Menu;
import rachni.masqueradb.UIConsole.MenuBuilder;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/masqueradb", "masqueradb", "masqueradb")) {
            System.out.println("Welcome to MasqueraDB");
            Menu menu = new MenuBuilder().build(connection);
            menu.execute();
            System.out.print("Leaving MasqueraDB...");
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}