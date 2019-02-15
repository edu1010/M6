package jdbc2;
import  java.sql.*;
/**Busca información sobre la interfaz ResultSetMetaData y realiza un
 programa utilizando dicha interfaz que obtenga el número de columnas y el
 tipo de columnas devueltos por la consulta “SELECT * FROM
 DEPARTAMENTOS”**/
public class ex4_1 {
    public static void main (String [] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo","root","austria");

            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul = conexion.createStatement().executeQuery("select * from depart");
            ResultSetMetaData resultSetMetaData = resul.getMetaData();
            int numeroColumnas=resultSetMetaData.getColumnCount();
            int culumnas = resultSetMetaData.getColumnCount();
            System.out.println("Numero de columnas:"+numeroColumnas);

            for(int i=1;i<=culumnas;i++){
                System.out.println("Tipo: "+resultSetMetaData.getColumnType(i));
            }










            conexion.close();
        }
        catch (ClassNotFoundException cn) {cn.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}
    }
}
