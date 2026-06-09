package ContaBancaria.Database;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {


    public static Connection conectar() {
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");

         return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/banco_java",
            "root",
            "836AXi6"
        );

        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
}
}


