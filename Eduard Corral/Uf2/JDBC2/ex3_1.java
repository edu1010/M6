package jdbc2;
import java.sql.*;
/**Genera un programa que devuelva la clave primaria de la tabla
 departamentos y la clave ajena que apunta a la tabla departamentos. NOTA:
 revisa que estén creadas las claves; tanto la primaria como la foránea.**/
public class ex3_1 {
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo","root","austria");
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul = null;
            ResultSet resul2 = null;

            resul = dbmd.getColumns(null,"ejemplo","depart",null);

            while (resul.next()){
                System.out.println("Clave primaria: "+resul.getString("COLUMN_NAME"));
            }

            resul2 = dbmd.getColumns(null,"ejemplo","depart",null);
            while (resul2.next()){
                System.out.println("Clave ajena: "+resul.getString("FKCOLUMN_NAME"));
            }


            conexion.close();
        }
        catch (ClassNotFoundException cn) {cn.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
    }

}
