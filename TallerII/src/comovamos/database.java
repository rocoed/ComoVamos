package comovamos;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
/*
 * Parte Elaborada por Oscar
 * Correspondiente a Tabla Editable.
 * Funciones: Altas-Bajas-Actualizaciones
 * ~NO~ Borrar
 */
public class database {
 /* DATOS PARA LA CONEXION */
  private String bd = "comovamos";//BASE DE DATOS
  private String login = "ozkar"; //USUARIO
  private String password = ""; //CONTRASEÑA
  private String url = "jdbc:mysql://localhost:3306/"+bd;
  private Connection conn = null;
  /* Constructor de clase: Se conecta a la base de datos
  */
  public static Connection cn;
        public static String sql;
        public static PreparedStatement ps;
        public static ResultSet rs;
        public static ResultSet rs2;
   public database(){
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("OK base de datos "+bd+" listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
    }

    public Connection getConnection(){
        return this.conn;
    }
/* Realiza una consulta a la base de datos, retorna un Object[][] con los
 * datos de la tabla persona
 */
    public Object[][] Select_Indicador(){
        try{
            sql = "SELECT * FROM COM_Indicador ";
            ps = Indicador.cn.prepareStatement(sql);
            rs = ps.executeQuery();

            sql="SELECT COUNT(*) FROM COM_Indicador ";
            ps=Indicador.cn.prepareStatement(sql);
            rs2=ps.executeQuery("SELECT COUNT(*) FROM COM_Indicador ");
            rs2.next();
            Object[][] tabla= new Object[rs2.getInt(1)][6];
            for (int i = 0;rs.next(); i++){
                tabla[i][0]=false;
                tabla[i][1]=rs.getString(2);
                tabla[i][2]=rs.getString(3);
		tabla[i][3]=rs.getString(4);
                tabla[i][4]=rs.getString(5);
                tabla[i][5]=rs.getInt(6);
            }
            return tabla;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
            return null;
        }
    }

/* Ejecuta la actualizacion de la tabla persona dado los valores de actualizacion
 * y el ID del registro a afectar
 */
    public boolean update(String valores, String id){
        boolean res = false;        
        String q = " UPDATE COM_Indicador SET " + valores + " WHERE IND_id = " + id;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }

}
