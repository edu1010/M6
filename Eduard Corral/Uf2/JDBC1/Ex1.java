package jdbc1;

import java.sql.*;
//**Tomando como base el programa que ilustra los pasos del funcionamiento de
//JDBC obtén el APELLIDO, OFICIO y SALARIO de los empleados del
//departamento 10**/
public class Ex1 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo","root","austria");
            Statement sentencia =conexion.createStatement();
            String sql = "SELECT * from depart where dept_no=10";
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