//Creado por: Marisol Padilla Bautista, Hector Sanchez Garrido y Fabiola Vasquez Ventura
package comovamos;

import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection conecta;
    Statement sentencia;
    ResultSet rsDatos;
    PreparedStatement psPreparasentencia;
    String Usuario1;
    String Contraseña1;
    Statement stm;
    PreparedStatement pstm;

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
        
        try{
            this.Usuario1=usuario;
            this.Contraseña1=contraseña;
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://148.226.81.254:3306/comovamos";
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
 /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conecta;
   }

   //permite cerrar la conexion
   public void desconectar(){
      conecta = null;
   }
   
   //permite hacer consultas de solo lectura recibe la conección, los campos que se quieren ver o * para todos,
   //las tablas de las cuales se van a obtener resultados, y las condiciones si es que hay si no pasa vacía
   //ejemplo con.select(conecta,"*","tabla1,tabla2","where tabla1.id=tabla2.id")
  public ResultSet select(Conexion con,String campos,String tablas,String condicion){
      ResultSet res=null; 
      try {
            stm=con.getConnection().createStatement();
            pstm=con.getConnection().prepareStatement("select "+campos+" from "+tablas+" "+condicion);
            res=pstm.executeQuery();
        }
        catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
  }

}
