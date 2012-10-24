//Creado por: Marisol Padilla Bautista, Hector Sanchez Garrido y Fabiola Vasquez Ventura
package comovamos;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana_inicio extends JFrame{


    JLabel eti_usuario, eti_contra;
    JPasswordField txt_contra;
    JTextField txt_usuario;
    JButton aceptar, cancelar;
    String emp1 = "administrador";
    boolean j;



    public Ventana_inicio() {
        super("Autentificacion de usuario ¿Como Vamos?");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(350, 200));
        setResizable(false);


        Dimension tamFrame = this.getSize();
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tamPantalla.width - tamFrame.width)/2, (tamPantalla.height - tamFrame.height)/2);

        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        txt_usuario = new JTextField();
        eti_usuario =new JLabel("Usuario: ");
        txt_usuario.setPreferredSize(new Dimension(250, 20));
        txt_usuario.setToolTipText("Id del empleado");
        contenedor.add(Box.createVerticalStrut(50));
        contenedor.add(eti_usuario);
        contenedor.add(txt_usuario);


        txt_contra = new JPasswordField();
        eti_contra = new JLabel("Contraseña: ");
        txt_contra.setPreferredSize(new Dimension(250, 20));
        contenedor.add(eti_contra);
        contenedor.add(txt_contra);


        aceptar = new JButton("Aceptar");
        getRootPane().setDefaultButton(aceptar);
        contenedor.add(aceptar);
        contenedor.add(Box.createVerticalStrut(75));


        cancelar = new JButton("Cancelar");
        contenedor.add(cancelar);


        ActionListener eAceptar = new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent e) {
                try{
                    if ( txt_contra.getText().length() > 0) {
                        if(validarUsuario(txt_usuario.getText(),txt_contra.getText())) {
                            setVisible(false);
                          //if(IdentificarPuesto(txt_usuario.getText(), emp1)){
                             JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                              Menu_Principal f = new Menu_Principal();
                              f.setVisible(true);



                   // }
                         // else{
                             //VentanaCaja v = new VentanaCaja();
                            //v.setVisible(true);
//JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                          //}

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "El usuario y/o contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                            txt_contra.setText("");
                            txt_contra.requestFocusInWindow();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Favor de introducir la contraseña", "Error", JOptionPane.WARNING_MESSAGE);
                        txt_contra.requestFocusInWindow();
                    }
                }
                catch(Exception e1){

                }
            }
        };
        aceptar.addActionListener(eAceptar);


        ActionListener eCancelar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        };
        cancelar.addActionListener(eCancelar);
    }

    private boolean validarUsuario(String usuario, String contra) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/comovamos?user=root,password=123456");
            Statement instruccion = conn.createStatement();
            ResultSet resultado = instruccion.executeQuery("select * from com_usuarios where USU_usuario = '"+usuario+"' and USU_contraseña = '"+contra+"';");
            if (resultado.first()){
                if(resultado.getString("USU_usuario").equals(usuario) && resultado.getString("USU_contraseña").equals(contra)) {

                  return true;
                }
                return false;
            }
            else
                return false;
        }
        catch(Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

/*private boolean IdentificarPuesto(String usuario, String emp1){
    try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4001/cfe?user=root");
            Statement instruccion = conn.createStatement();
            ResultSet resultado = instruccion.executeQuery("select * from empleado where IDEmp = '"+usuario+"' and puesto ='"+emp1+"';");
       if (resultado.first()){
          if(resultado.getString("IDEmp").equals(usuario)) {
             if (resultado.getString("puesto").equals(emp1)){

               return true;
                }

             else {

               return false;
             }
        }
                }
            return false;
     }
        catch(Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }

    }*/



}
