package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Frame;
import javax.swing.JFrame;

public class MySQL {

    private static Connection connection;

    static {

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Upek@2004");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ResultSet execute(String query) throws Exception {

        Statement statement = connection.createStatement();

        if (query.startsWith("SELECT")) {
            return statement.executeQuery(query);
        } else {
            statement.executeUpdate(query);
            return null;
        }

    }

}
