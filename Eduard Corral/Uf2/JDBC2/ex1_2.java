package jdbc2;
import java.sql.*;
/**Realiza un programa en Java que suba el salario a los empleados de un
 departamento. El programa recibirá el número de departamento y el
 incremento.**/
public class ex1_2 {
    public static void main (String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/ejemplo","root","austria");
            String dep = args[0];
            String num = args[1];
            String sql = String.format("update emple set salario=salario"+num+"where dept_no="+dep);
            System.out.println(sql);
            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql);
            System.out.printf("Filas afectadas: %d %n", filas);
            sentencia.close();
            conexion.close();
        }
        catch (ClassNotFoundException cn) {cn.printStackTrace();}
        catch (SQLException e) {e.printStackTrace();}catch (Exception e){e.printStackTrace();}
    }



}
