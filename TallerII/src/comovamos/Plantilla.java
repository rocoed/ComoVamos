package comovamos;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
/*
 * Parte Elaborada por Oscar
 * Correspondiente a la Entidad (Catalogos) COM_Plantilla, Elaborado con Clases
 * Funciones: Altas-Bajas-Actualizaciones-Busquedas
 * ~NO~ Borrar
 * Faltan cosas
 */
public class Plantilla{
        public static Connection cn;
        public static String sql;
        public static PreparedStatement ps;
        public static ResultSet rs;
        public static ResultSet rs2;

        private static int PLA_id;
        private static String PLA_NomPlantilla;
        private static String PLA_Descripcion;
        private static String PLA_Periodo;
        private static int PLA_Indicador;
        private static int PLA_Usuario;
    public Plantilla(){
        cn = null;
        PLA_id = 1;
        PLA_NomPlantilla = "";
        PLA_Descripcion = "";
        PLA_Periodo = "";
        PLA_Indicador = 1;
        PLA_Usuario = 1;
    }
    public Plantilla(int PLA_id, String PLA_NomPlantilla,String PLA_Descripcion, String PLA_Periodo, int PLA_Indicador,int PLA_Usuario){
        this.PLA_id = PLA_id;
        this.PLA_NomPlantilla = PLA_NomPlantilla;
        this.PLA_Descripcion = PLA_Descripcion;
        this.PLA_Periodo = PLA_Periodo;
        this.PLA_Indicador = PLA_Indicador;
        this.PLA_Usuario = PLA_Usuario;
        this.cn = cn;
    }
    /*****GET*****/
    public static int getPLA_id(){
        return PLA_id;
    }
    public static String getPLA_NomPlantilla(){
        return PLA_NomPlantilla;
    }
    public static String getPLA_Descripcion(){
        return PLA_Descripcion;
    }
    public static String getPLA_Periodo(){
        return PLA_Periodo;
    }
    public static int getPLA_Indicador(){
        return PLA_Indicador;
    }
    public static int getPLA_Usuario(){
        return PLA_Usuario;
    }
    /*****SET*****/
    public static void setPLA_id(int PLA_id){
        Plantilla.PLA_id = PLA_id;
    }
    public static void setPLA_NomPlantilla(String PLA_NomPlantilla){
        Plantilla.PLA_NomPlantilla = PLA_NomPlantilla;
    }
    public static void setPLA_Descripcion(String PLA_Descripcion){
        Plantilla.PLA_Descripcion = PLA_Descripcion;
    }
    public static void setPLA_Periodo(String PLA_Periodo){
        Plantilla.PLA_Periodo = PLA_Periodo;
    }
    public static void setPLA_Indicador(int PLA_Indicador){
        Plantilla.PLA_Indicador = PLA_Indicador;
    }
    public static void setPLA_Usuario(int PLA_Usuario){
        Plantilla.PLA_Usuario = PLA_Usuario;
    }
    public boolean equals(Object obj){
        if (obj == null)    return false;
        if (getClass() != obj.getClass())   return false;
        Plantilla otro = (Plantilla) obj;
        //idMatr=Integer.parseInt(TxtidPlantilla.getText());
        //return PLA_id.equals(otro.getidPlantilla());
        return otro.equals(otro.ToString());
    }
    public String ToString(){
        return "PLA_id: "+PLA_id+", PLA_NomPlantilla: "+PLA_NomPlantilla+", PLA_Descripcion: "+PLA_Descripcion+", PLA_Periodo: "+PLA_Periodo+", PLA_Indicador: "+PLA_Indicador;
    }
   public static void cargarDriver(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error NO se puede Cargar el Driver: "+e.getMessage());
        }
    }
    public static void conexionBaseDatos(String Usuario, String Password){
        try{
            String url = "jdbc:mysql://localhost:3306/comovamos";
            String user = Usuario;
            String password = Password;
            cn = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error NO se puede Establecer la Conexion General BD Como Vamos: "+e.getMessage());
        }
        //JOptionPane.showMessageDialog(null,"Conexion General Exitosa con BD Como Vamos");
    }
    public static void RegistrarPlantilla(){
        try{
            sql = "INSERT INTO COM_Plantilla VALUES (?,?,?,?,?,?)";
            ps = Plantilla.cn.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, PLA_NomPlantilla);
	    ps.setString(3, PLA_Descripcion);
            ps.setString(4, PLA_Periodo);
            ps.setInt(5, PLA_Indicador);
            ps.setInt(6, PLA_Usuario);
            ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
        }
    }
    public static void ModificarPlantilla(String codmod){
        try{
            sql = "UPDATE COM_Plantilla SET PLA_NomPlantilla = ?, PLA_Descripcion = ?, PLA_Periodo = ?, PLA_Indicador = ?, PLA_Usuario = ? where PLA_id = ?";
            ps = Plantilla.cn.prepareStatement(sql);
            ps.setString(1, PLA_NomPlantilla);
	    ps.setString(2, PLA_Descripcion);
            ps.setString(3, PLA_Periodo);
            ps.setInt(4, PLA_Indicador);
            ps.setInt(5, PLA_Usuario);
            ps.setString(6, codmod);
            ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
        }
    }
    public static boolean BuscarPlantilla(String codmod){
        try{
            sql = "SELECT * FROM COM_Plantilla WHERE PLA_id = " + codmod;
            ps = Plantilla.cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                PLA_id = rs.getInt(1);
                PLA_NomPlantilla = rs.getString(2);
                PLA_Descripcion = rs.getString(3);
                PLA_Periodo = rs.getString(4);
                PLA_Indicador = rs.getInt(5);
                PLA_Usuario = rs.getInt(6);
                return true;
            }
            else
                return false;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
            return false;
        }
    }
    public static boolean EliminaPlantilla(String cod){
        try{
            sql = "DELETE FROM COM_Plantilla WHERE PLA_id = ?";
            ps = Plantilla.cn.prepareStatement(sql);
            ps.setString(1, cod);
            int nro = ps.executeUpdate();
            if(nro > 0)
                return true;
            else
                return false;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
            return false;
        }
    }
    public static Object[][] Reportar(){
        try{
            sql = "SELECT * FROM COM_Plantilla ";
            ps = Plantilla.cn.prepareStatement(sql);
            rs = ps.executeQuery();

            sql="SELECT COUNT(*) FROM COM_Plantilla ";
            ps=Plantilla.cn.prepareStatement(sql);
            rs2=ps.executeQuery("SELECT COUNT(*) FROM COM_Plantilla ");
            rs2.next();
            Object[][] tabla= new Object[rs2.getInt(1)][6];
            for (int i = 0;rs.next(); i++){
                tabla[i][0]=rs.getInt(1);
                tabla[i][1]=rs.getString(2);
                tabla[i][2]=rs.getString(3);
		tabla[i][3]=rs.getString(4);
                tabla[i][4]=rs.getInt(5);
                tabla[i][5]=rs.getInt(6);
            }
            return tabla;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
            return null;
        }
    }
}