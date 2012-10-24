//Creado por: Marisol Padilla Bautista, Hector Sanchez Garrido y Fabiola Vasquez Ventura
package comovamos;

import java.sql.*;
import javax.swing.*;

public class Conexion {

    Connection conecta;
    Statement sentencia;
    ResultSet rsDatos;
    PreparedStatement psPreparasentencia;
    String Usuario1;
    String Contraseña1;

    public String getContraseña1() {
        return Contraseña1;
    }

    public String getUsuario1() {
        return Usuario1;
    }

    public void setContraseña1(String Contraseña1) {
        this.Contraseña1 = Contraseña1;
    }

    public void setUsuario1(String Usuario1) {
        this.Usuario1 = Usuario1;
    }




    public Conexion(String usuario, String contraseña) throws SQLException, ClassNotFoundException
    {
        //System.out.println(usuario);
        try{
            this.Usuario1=usuario;
            this.Contraseña1=contraseña;
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://72.3.165.53/389884_test?user=389884_test&amp;password=filiful";
            conecta=DriverManager.getConnection(url,Usuario1,Contraseña1);
            sentencia=conecta.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch(ClassCastException ex){
            throw ex;
        }catch(SQLException ex1){
            throw ex1;
        }
    }


public ResultSet consulta(String sql) throws SQLException
{
    try{
        rsDatos=sentencia.executeQuery(sql);
          }catch (SQLException ex){
              throw ex;
          }
    return rsDatos;
}
public void ejecutar(String sql)throws SQLException
{
    try{
        sentencia.execute(sql);
    } catch (SQLException ex){
        throw ex;
    }
}

}
