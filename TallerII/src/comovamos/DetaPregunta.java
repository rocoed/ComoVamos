package comovamos;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
/*
 * Parte Elaborada por Oscar
 * Correspondiente a la Entidad (Catalogos) COM_DetallePregunta, Elaborado con Clases
 * Funciones: Altas-Bajas-Actualizaciones-Busquedas
 * ~NO~ Borrar
 * Faltan Cosas
 */
public class DetaPregunta {
        public static Connection cn;
        public static String sql;
        public static PreparedStatement ps;
        public static ResultSet rs1;
        public static ResultSet rs2;

         private static int DET_id;
         private static String DET_Pregunta;
         private static String DET_Tipo;
         private static String DET_Formula;
         private static String DET_Resultado;
         private static String DET_Color;
         private static int DET_Plantilla;

    public DetaPregunta(){
        java.util.Date fecha = new java.util.Date();
        DET_id = 1;
        DET_Pregunta = "";
        DET_Tipo = "";
	DET_Formula = "";
        DET_Resultado = "";
        DET_Color = "";
        DET_Plantilla = 1;
    }
    public DetaPregunta(int DET_id, String DET_Pregunta, String DET_Tipo, String DET_Formula, String DET_Resultado, String DET_Color, int DET_Plantilla){
        this.DET_id = DET_id ;
        this.DET_Pregunta = DET_Pregunta;
        this.DET_Tipo = DET_Tipo;
	this.DET_Formula = DET_Formula;
        this.DET_Resultado = DET_Resultado;
        this.DET_Color = DET_Color;
        this.DET_Plantilla = DET_Plantilla;
    }
    /*****GET*****/
    public static int getDET_id(){
        return DET_id;
    }
    public static String getDET_Pregunta(){
        return DET_Pregunta;
    }
    public static String getDET_Tipo(){
        return DET_Tipo;
    }
    public static String getDET_Formula(){
        return DET_Formula;
    }
    public static String getDET_Resultado(){
        return DET_Resultado;
    }
    public static String getDET_Color(){
        return DET_Color;
    }
    public static int getDET_Plantilla(){
        return DET_Plantilla;
    }
    /*****SET*****/
    public static void setDET_id(int DET_id){
        DetaPregunta.DET_id = DET_id;
    }
    public static void setDET_Pregunta(String DET_Pregunta){
        DetaPregunta.DET_Pregunta = DET_Pregunta;
    }
    public static void setDET_Tipo(String DET_Tipo){
        DetaPregunta.DET_Tipo = DET_Tipo;
    }
    public static void setDET_Formula(String DET_Formula){
        DetaPregunta.DET_Formula = DET_Formula;
    }
    public static void setDET_Resultado(String DET_Resultado){
        DetaPregunta.DET_Resultado = DET_Resultado;
    }
    public static void setDET_Color(String DET_Color){
        DetaPregunta.DET_Color = DET_Color;
    }
    public static void setDET_Plantilla(int DET_Plantilla){
        DetaPregunta.DET_Plantilla = DET_Plantilla;
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
    public static void RegistrarDetaPregunta(){
        try{
            sql = "INSERT INTO COM_DetallePreguntas VALUES (?,?,?,?,?,?,?)";
            ps = DetaPregunta.cn.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, DET_Pregunta);
	    ps.setString(3, DET_Tipo);
            ps.setString(4, DET_Formula);
            ps.setString(5, DET_Resultado);
            ps.setString(6, DET_Color);
            ps.setInt(7, DET_Plantilla);
            ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
        }
    }
    public static void ModificarDetaPregunta(String codmod){
        try{
            sql = "UPDATE COM_DetallePreguntas SET DET_Pregunta = ?, DET_Tipo = ?, DET_Formula = ?,DET_Resultado = ?, DET_Color = ?, DET_Plantilla = ? where DET_id = ?";
            ps = DetaPregunta.cn.prepareStatement(sql);
            ps.setString(1, DET_Pregunta);
	    ps.setString(2, DET_Tipo);
            ps.setString(3, DET_Formula);
            ps.setString(4, DET_Resultado);
            ps.setString(5, DET_Color);
            ps.setInt(6, DET_Plantilla);
            ps.setString(7, codmod);
            ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
        }
    }
    public static boolean BuscarDetaPregunta(String codmod){
        try{
            sql = "SELECT * FROM COM_DetallePreguntas WHERE DET_id = " + codmod;
            ps = DetaPregunta.cn.prepareStatement(sql);
            rs1 = ps.executeQuery();
            if(rs1.next()){
                DET_id = rs1.getInt(1);
                DET_Pregunta = rs1.getString(2);
                DET_Tipo = rs1.getString(3);
                DET_Formula = rs1.getString(4);
                DET_Resultado = rs1.getString(5);
                DET_Color = rs1.getString(6);
                DET_Plantilla = rs1.getInt(7);
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
    public static boolean EliminaDetaPregunta(String cod){
        try{
            sql = "DELETE FROM COM_DetallePreguntas WHERE DET_id = ?";
            ps = DetaPregunta.cn.prepareStatement(sql);
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
            sql = "SELECT * FROM COM_DetallePreguntas ";
            ps = DetaPregunta.cn.prepareStatement(sql);
            rs1 = ps.executeQuery();

            sql="SELECT COUNT(*) FROM COM_DetallePreguntas ";
            ps=DetaPregunta.cn.prepareStatement(sql);
            rs2=ps.executeQuery("SELECT COUNT(*) FROM COM_DetallePreguntas ");
            rs2.next();
            Object[][] table = new Object[rs2.getInt(1)][7];
            for (int i = 0;rs1.next(); i++){
                table[i][0] = rs1.getInt(1);
                table[i][1] = rs1.getString(2);
                table[i][2] = rs1.getString(3);
		table[i][3] = rs1.getString(4);
                table[i][4] = rs1.getString(5);
                table[i][5] = rs1.getString(6);
                table[i][6] = rs1.getInt(7);
            }
            return table;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
            return null;
        }
    }
}
