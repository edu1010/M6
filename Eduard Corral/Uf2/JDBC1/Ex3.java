package jdbc1;
import java.sql.*;
import java.io.*;
/**Realiza un programa que busque los departamentos de una localidad. El
 programa solicitará el nombre de una localidad al usuario y devolverá los
 departamentos asociados a dicha localidad y los empleados de dicho
 departamentos.**/
public class Ex3 {
    public static void main(String[] args) {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplo","root","austria");
            Statement sentencia =conexion.createStatement();

            System.out.println("Introduzca una localidad: ");
            String localidad=buffer.readLine();

            String sql = "select dnombre, loc, apellido from depart, emple where depart.dept_no = emple.dept_no and loc=';"+localidad+"'";

            ResultSet result = sentencia.executeQuery(sql);

            while (result.next()){
                System.out.printf("%s, %s, %s, %n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3));

            }
            result.close();
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException cn) { cn.printStackTrace();
        } catch (SQLException e) {e.printStackTrace();
        }catch (Exception a){a.printStackTrace();
        }
    }
}