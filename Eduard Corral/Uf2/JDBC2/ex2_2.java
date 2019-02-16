package jdbc2;
import java.sql.*;
/**Realiza un programa que cree una vista (de nombre “totales”) que contenga
 por cada departamento el número de departamento, el nombre, el número
 de empleados que tiene y el salario medio.**/
public class ex2_2 {
    public static void main (String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/ejemplo","root","austria");
            //String dep = args[0];
            //String num = args[1];

            String sql = String.format("create view totales as select depart.dept_no, dnombre, count(emp_no), avg(salario) from emple,depart where depart.dept_no=emple.dept_no;");

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
