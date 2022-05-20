import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexioBD {

    private static Connection conBD = null;

    private String servidor;
    private String bbdd;
    private String user;
    private String password;

    private ConexioBD() {

        servidor = "jdbc:mysql://localhost:3306/";
        bbdd = "nwn";
        user = "root";
        password = "1234";

        try {
            conBD = DriverManager.getConnection(servidor + bbdd, user, password);
        } catch (SQLException ex) {
            System.out.println("No sa pogut connectar");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {

        if (conBD == null) {
            new ConexioBD();
        }

        return conBD;
    }

    public void desBD() {

        try {
            conBD.close();
        } catch (SQLException e) {

            System.out.println("No sa pogut tancar la conexio amb la base de dades");
            e.printStackTrace();
        }
    }

}
