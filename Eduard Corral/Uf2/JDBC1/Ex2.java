package jdbc1;

import java.sql.*;
/**Realiza otro programa Java utilizando la base de datos “ejemplo” que
 visualice el APELLIDO del empleado con máximo salario, visualiza también
 su SALARIO y el nombre del departamento. **/
public class Ex2 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo","root","austria");
            Statement sentencia =conexion.createStatement();
            String sql = "SELECT * from depart order by sal ";
            ResultSet result = sentencia.executeQuery(sql);
            while (result.next()){
                System.out.printf("%d, %s, %s, %n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3));
            }
            result.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException cn) { cn.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }
    }
}