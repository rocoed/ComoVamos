package comovamos;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
/*
 * Parte Elaborada por Oscar
 * Correspondiente a la Entidad (Catalogos) COM_DetallePreguntas
 * Funciones: Altas-Bajas-Actualizaciones-Busquedas
 * ~NO~ Borrar
 * Faltan Cosas
 */
public class frmDetaPregunta extends javax.swing.JInternalFrame {
    java.util.Date fecha = new java.util.Date();
    DefaultTableModel modeloe = new DefaultTableModel();
    Connection cnn;
    String codigo = "";
    String sqli = null;
    PreparedStatement psi;
    ResultSet rsi;
    int filas;
    int DET_id= 0, DET_Plantilla= 0;
    String DET_Pregunta = "",DET_Tipo = "",DET_Formula = "",DET_Resultado = "",DET_Color = "";
    String nombreColumnas[]={"DET_id","DET_Pregunta","DET_Tipo","DET_Formula","DET_Resultado","DET_Color","DET_Plantilla"};
    boolean reg, autoreg,salidareg;
    String codmod;
    int MAXIMIZED_BOTH;
    /** Creates new form frmDetaPregunta */
    public frmDetaPregunta() {
        initComponents();
        Cargar();
    }
void Cargar(){
        String Usuario ="ozkar";
        String Pass ="";
        DetaPregunta.cargarDriver();
        DetaPregunta.conexionBaseDatos(Usuario, Pass);
        modeloe.setDataVector(DetaPregunta.Reportar(), nombreColumnas);
    }
    void LimpiarTxts(){
            Txtid.setText("");
            TxtPregunta.setText("");
            TxtTipo.setText("");
            TxtFormula.setText("");
            TxtResultado.setText("");
            TxtColor.setText("");
            TxtPlantilla.setText("");
            ComboPlantilla.removeAllItems();
    }
    void Habilitar(){
        Txtid.setEnabled(true);
        TxtPregunta.setEnabled(true);
        TxtTipo.setEnabled(true);
        TxtFormula.setEnabled(true);
        TxtResultado.setEnabled(true);
        TxtColor.setEnabled(true);
        TxtPlantilla.setEnabled(true);
        ComboPlantilla.setEnabled(true);
    }
    void AgregarItemsDetaPregunta(){
        try{
            sqli = "SELECT * FROM COM_DetallePreguntas ";
            psi = DetaPregunta.cn.prepareStatement(sqli);
            rsi = psi.executeQuery();
            while(rsi.next()){
                ComboPlantilla.addItem(rsi.getObject(2));
            }
         }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToolDetaPregunta = new javax.swing.JToolBar();
        NuevoDetaPregunta = new javax.swing.JButton();
        ModificarDetaPregunta = new javax.swing.JButton();
        AgregarDetaPregunta = new javax.swing.JButton();
        EliminarDetaPregunta = new javax.swing.JButton();
        BuscarDetaPregunta = new javax.swing.JButton();
        ScrollDetaPregunta = new javax.swing.JScrollPane();
        TablaDetaPregunta = new javax.swing.JTable();
        PanelLabel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Txtid = new javax.swing.JTextField();
        TxtPregunta = new javax.swing.JTextField();
        TxtTipo = new javax.swing.JTextField();
        TxtFormula = new javax.swing.JTextField();
        TxtResultado = new javax.swing.JTextField();
        TxtColor = new javax.swing.JTextField();
        TxtPlantilla = new javax.swing.JTextField();
        ComboPlantilla = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Catalogo de Detalle Preguntas de Enuestas");

        ToolDetaPregunta.setRollover(true);

        NuevoDetaPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Agregar.png"))); // NOI18N
        NuevoDetaPregunta.setText("Nuevo");
        NuevoDetaPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoDetaPreguntaActionPerformed(evt);
            }
        });
        ToolDetaPregunta.add(NuevoDetaPregunta);

        ModificarDetaPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Modificar.png"))); // NOI18N
        ModificarDetaPregunta.setText("Modificar");
        ModificarDetaPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarDetaPreguntaActionPerformed(evt);
            }
        });
        ToolDetaPregunta.add(ModificarDetaPregunta);

        AgregarDetaPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Guardar.png"))); // NOI18N
        AgregarDetaPregunta.setText("Agregar");
        AgregarDetaPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarDetaPreguntaActionPerformed(evt);
            }
        });
        ToolDetaPregunta.add(AgregarDetaPregunta);

        EliminarDetaPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Eliminar.png"))); // NOI18N
        EliminarDetaPregunta.setText("Eliminar");
        EliminarDetaPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarDetaPreguntaActionPerformed(evt);
            }
        });
        ToolDetaPregunta.add(EliminarDetaPregunta);

        BuscarDetaPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/search.png"))); // NOI18N
        BuscarDetaPregunta.setText("Buscar");
        BuscarDetaPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarDetaPreguntaActionPerformed(evt);
            }
        });
        ToolDetaPregunta.add(BuscarDetaPregunta);

        TablaDetaPregunta.setModel(modeloe);
        ScrollDetaPregunta.setViewportView(TablaDetaPregunta);

        jLabel1.setText("DET Pregunta Llave");

        jLabel2.setText("Pregunta");

        jLabel3.setText("Tipo");

        jLabel4.setText("Formula");

        jLabel5.setText("Color");

        jLabel6.setText("PLA Plantilla");

        jLabel7.setText("Resultado");

        javax.swing.GroupLayout PanelLabelLayout = new javax.swing.GroupLayout(PanelLabel);
        PanelLabel.setLayout(PanelLabelLayout);
        PanelLabelLayout.setHorizontalGroup(
            PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                    .addComponent(jLabel7)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addContainerGap())
                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        PanelLabelLayout.setVerticalGroup(
            PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLabelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jLabel6))
        );

        Txtid.setEnabled(false);
        Txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtidActionPerformed(evt);
            }
        });

        TxtPregunta.setEnabled(false);
        TxtPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPreguntaActionPerformed(evt);
            }
        });

        TxtTipo.setEnabled(false);

        TxtFormula.setEnabled(false);
        TxtFormula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtFormulaKeyTyped(evt);
            }
        });

        TxtResultado.setEnabled(false);
        TxtResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtResultadoKeyTyped(evt);
            }
        });

        TxtColor.setEnabled(false);
        TxtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtColorKeyTyped(evt);
            }
        });

        TxtPlantilla.setEnabled(false);
        TxtPlantilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPlantillaKeyTyped(evt);
            }
        });

        ComboPlantilla.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(TxtPregunta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(TxtTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(TxtFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(TxtResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(TxtColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(TxtPlantilla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(ComboPlantilla, 0, 211, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(ComboPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ToolDetaPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollDetaPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(PanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolDetaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ScrollDetaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoDetaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoDetaPreguntaActionPerformed
        LimpiarTxts();
        reg = true;
        rsi = null;
        ComboPlantilla.removeAllItems();
        try {
            rsi = DetaPregunta.ps.executeQuery("SELECT * FROM COM_DetallePreguntas ");
            while(rsi.next()){
                ComboPlantilla.addItem(rsi.getObject(2));
            }
        } catch (SQLException ex){
            Logger.getLogger(frmDetaPregunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Habilitar();
        AgregarItemsDetaPregunta();
        Txtid.setEnabled(false);
        TxtPregunta.requestFocus();
}//GEN-LAST:event_NuevoDetaPreguntaActionPerformed

    private void ModificarDetaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarDetaPreguntaActionPerformed
        LimpiarTxts();
        AgregarItemsDetaPregunta();
        Habilitar();
        codmod=JOptionPane.showInputDialog("Ingrese el código del DetaPregunta a Buscar: ");
        if(DetaPregunta.BuscarDetaPregunta(codmod)) {
            Txtid.setText(String.valueOf(DetaPregunta.getDET_id()));
            TxtPregunta.setText(DetaPregunta.getDET_Pregunta());
            TxtTipo.setText(DetaPregunta.getDET_Tipo());
            TxtFormula.setText(DetaPregunta.getDET_Formula());
            TxtResultado.setText(DetaPregunta.getDET_Resultado());
            TxtColor.setText(DetaPregunta.getDET_Color());
            TxtPlantilla.setText(String.valueOf(DetaPregunta.getDET_Plantilla()));
            reg = false;
        } else{
            JOptionPane.showMessageDialog(null,"El Código del DetaPregunta No fue encontrado");
            reg = true;
        }
}//GEN-LAST:event_ModificarDetaPreguntaActionPerformed

    private void AgregarDetaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarDetaPreguntaActionPerformed
        if(!TxtTipo.getText().equals("") && !TxtPregunta.getText().equals("") && !TxtFormula.getText().equals("") && !TxtPlantilla.getText().equals("")) {
            //DET_Pregunta = TxtNombre.getText();
            //DET_Pregunta = (String) ComboPlantilla.getSelectedItem();
            DET_Pregunta = TxtPregunta.getText();
            JOptionPane.showMessageDialog(null,"Campo "+ DET_Pregunta);
            DET_Tipo = TxtTipo.getText();
            DET_Formula = TxtFormula.getText();
            DET_Resultado = TxtResultado.getText();
            DET_Color = TxtColor.getText();
            DET_Plantilla = Integer.parseInt(TxtPlantilla.getText());
            DetaPregunta aal = new DetaPregunta(DET_id,  DET_Pregunta,  DET_Tipo,  DET_Formula,  DET_Resultado,  DET_Color, DET_Plantilla);
            if(reg) {
                DetaPregunta.RegistrarDetaPregunta();
                JOptionPane.showMessageDialog(null,"DetaPregunta Registrado");
                modeloe.setDataVector(DetaPregunta.Reportar(), nombreColumnas);
            } else {
                DetaPregunta.ModificarDetaPregunta(codmod);
                JOptionPane.showMessageDialog(null,"DetaPregunta Modificado");
                modeloe.setDataVector(DetaPregunta.Reportar(), nombreColumnas);
            }
        } else    JOptionPane.showMessageDialog(null,"Campos Vacios, Favor de Llenar Datos Correspondientes");
}//GEN-LAST:event_AgregarDetaPreguntaActionPerformed

    private void EliminarDetaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarDetaPreguntaActionPerformed
        codigo=JOptionPane.showInputDialog("Ingrese el código del DetaPregunta a Buscar:  ");
        if(DetaPregunta.BuscarDetaPregunta(codigo)) {
            Txtid.setText(String.valueOf(DetaPregunta.getDET_id()));
            TxtPregunta.setText(DetaPregunta.getDET_Pregunta());
            TxtTipo.setText(DetaPregunta.getDET_Tipo());
            TxtFormula.setText(DetaPregunta.getDET_Formula());
            TxtResultado.setText(DetaPregunta.getDET_Resultado());
            TxtColor.setText(DetaPregunta.getDET_Color());
            TxtPlantilla.setText(String.valueOf(DetaPregunta.getDET_Plantilla()));
            int resp= JOptionPane.showConfirmDialog(this,"Esta Seguro de Eliminar Regitro ","Eliminar Dato",JOptionPane.YES_NO_OPTION );
            if( resp == JOptionPane.YES_OPTION ){
                DetaPregunta.EliminaDetaPregunta(codigo);
                JOptionPane.showMessageDialog(this,"Registro Eliminado");
                modeloe.setDataVector(DetaPregunta.Reportar(), nombreColumnas);
            }
            LimpiarTxts();
        } else JOptionPane.showMessageDialog(null,"El Código del DetaPregunta No fue encontrado");
}//GEN-LAST:event_EliminarDetaPreguntaActionPerformed

    private void BuscarDetaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarDetaPreguntaActionPerformed
        codigo=JOptionPane.showInputDialog("Ingrese el código del DetaPregunta a Buscar:  ");
        DetaPregunta.BuscarDetaPregunta(codigo);
        if(DetaPregunta.BuscarDetaPregunta(codigo)) {
            Txtid.setText(String.valueOf(DetaPregunta.getDET_id()));
            TxtPregunta.setText(DetaPregunta.getDET_Pregunta());
            TxtTipo.setText(DetaPregunta.getDET_Tipo());
            TxtFormula.setText(DetaPregunta.getDET_Formula());
            TxtResultado.setText(DetaPregunta.getDET_Resultado());
            TxtColor.setText(DetaPregunta.getDET_Color());
            TxtPlantilla.setText(String.valueOf(DetaPregunta.getDET_Plantilla()));
        } else{
            JOptionPane.showMessageDialog(null,"El Código del DetaPregunta No fue encontrado");
            LimpiarTxts();
            modeloe.setDataVector(DetaPregunta.Reportar(), nombreColumnas);
        }
        DetaPregunta.Reportar();

        JCheckBox comboBox = new JCheckBox();
        JComboBox comboBox2 =new JComboBox();

        try {
            rsi = DetaPregunta.ps.executeQuery("SELECT * FROM COM_DetallePreguntas ");
            while(rsi.next()){
                comboBox.setSelected(true);
                comboBox2.addItem(rsi.getObject(3));
            }
        } catch (SQLException ex){
            Logger.getLogger(frmDetaPregunta.class.getName()).log(Level.SEVERE, null, ex);
        }

        TablaDetaPregunta.setCellEditor(new DefaultCellEditor(comboBox2)); //enfasis en esta linea!!!!
        DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox2);
        TablaDetaPregunta.getColumnModel().getColumn(3).setCellEditor(defaultCellEditor);
        AgregarItemsDetaPregunta();
}//GEN-LAST:event_BuscarDetaPreguntaActionPerformed

    private void TxtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtidActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_TxtidActionPerformed

    private void TxtPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPreguntaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_TxtPreguntaActionPerformed

    private void TxtFormulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFormulaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
}//GEN-LAST:event_TxtFormulaKeyTyped

    private void TxtPlantillaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPlantillaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
}//GEN-LAST:event_TxtPlantillaKeyTyped

    private void TxtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtColorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtColorKeyTyped

    private void TxtResultadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtResultadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtResultadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarDetaPregunta;
    private javax.swing.JButton BuscarDetaPregunta;
    private javax.swing.JComboBox ComboPlantilla;
    private javax.swing.JButton EliminarDetaPregunta;
    private javax.swing.JButton ModificarDetaPregunta;
    private javax.swing.JButton NuevoDetaPregunta;
    private javax.swing.JPanel PanelLabel;
    private javax.swing.JScrollPane ScrollDetaPregunta;
    private javax.swing.JTable TablaDetaPregunta;
    private javax.swing.JToolBar ToolDetaPregunta;
    private javax.swing.JTextField TxtColor;
    private javax.swing.JTextField TxtFormula;
    private javax.swing.JTextField TxtPlantilla;
    private javax.swing.JTextField TxtPregunta;
    private javax.swing.JTextField TxtResultado;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JTextField Txtid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
