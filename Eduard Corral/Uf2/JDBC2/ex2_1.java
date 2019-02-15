package jdbc2;
import java.sql.*;
/**Genera un programa en Java que muestre el nombre, el tipo, el tamaño y si
 puede ser nulo o no, de las columnas de la tabla departamentos. **/
public class ex2_1 {
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo","root","austria");
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul = null;

            resul = dbmd.getColumns(null,"ejemplo","depart",null);

            while (resul.next()){
                String nombre = resul.getString(4);
                String tipo = resul.getString(6);
                String tamaño = resul.getString(7);
                String nulo = resul.getString(11);
                System.out.printf("%s - nombre: %s, tipo: %s, tamaño: %s,%n nulo %n" ,nombre,tipo,tamaño, nulo);
            }
            conexion.close();
        }
        catch (ClassNotFoundException cn) {cn.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
    }
}

