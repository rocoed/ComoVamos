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
import javax.swing.table.TableRowSorter;
/*
 * Parte Elaborada por Oscar
 * Correspondiente a la Entidad (Catalogos) COM_Indicador
 * Funciones: Altas-Bajas-Actualizaciones-Busquedas
 * ~NO~ Borrar
 */
public class frmIndicador extends javax.swing.JInternalFrame {
 private database db = new database();
    private Object[][] dtPersona;
    boolean IND_flag = false;
    java.util.Date fecha = new java.util.Date();
    //Para Llenar la Tabla ~> Tabla Indicadores
    DefaultTableModel modelo = new DefaultTableModel();
    //Para Agregar Items al ComboBox desde la BD
    Connection cnn;
    String sqli = null;
    PreparedStatement psi;
    ResultSet rsi;
    //Variables Globales
    int filas,IND_id= 0, IND_Padre= 0;
    String IND_Nombre = "",IND_indicadorcol = "",IND_Formula = "",IND_Color = "", codigo  = "";
    boolean reg, autoreg,salidareg;
    String codmod;    
    //Llenar Encabezado de Campo de la Tabla
    String nombreColumnas[]={"IND_flag","IND_id","IND_Nombre","IND_Formula","IND_Color","IND_PadreNombre"};
    
    /** Creates new form frmIndicador */
    public frmIndicador() {
        initComponents();
        Cargar();
    }
    
void Cargar(){
        String Usuario ="ozkar";
        String Pass ="";
        Indicador.cargarDriver();
        Indicador.conexionBaseDatos(Usuario, Pass);
         modelo.setDataVector(Indicador.Reportar(), nombreColumnas);
         TablaPer();
    }
void TablaPer(){
        TablaIndicadores.getColumnModel().getColumn( 0 ).setCellEditor(new MyTableCellEditor(db,"IND_flag"));//Columna Apellido
        TablaIndicadores.getColumnModel().getColumn( 2 ).setCellEditor(new MyTableCellEditor(db,"IND_Nombre"));//Columna Apellido
        TablaIndicadores.getColumnModel().getColumn( 3 ).setCellEditor(new MyTableCellEditor(db,"IND_Formula"));//Columna Edad
        TablaIndicadores.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditor(db,"IND_Color"));//Columna Edad
        TablaIndicadores.getColumnModel().getColumn( 5 ).setCellEditor(new MyTableCellEditor(db,"IND_Padre"));//Columna Edad
        //Agregar CheckBox
        TablaIndicadores.getColumnModel().getColumn( 0 ).setCellEditor( new Celda_CheckBox() );
        TablaIndicadores.getColumnModel().getColumn( 0 ).setCellRenderer(new Render_CheckBox());
         //Tamaño fijo para el jCheckBox Columna 0 ***IND_id***
        TablaIndicadores.getColumnModel().getColumn(0).setMaxWidth(25);
        TablaIndicadores.getColumnModel().getColumn(0).setMinWidth(25);
        TablaIndicadores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(25);
        TablaIndicadores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(25);
        //Ocultar ***IND_id*** Llave Primaria Columna 1 ~> 0
        TablaIndicadores.getColumnModel().getColumn(1).setMaxWidth(50);
        TablaIndicadores.getColumnModel().getColumn(1).setMinWidth(50);
        TablaIndicadores.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(50);
        TablaIndicadores.getTableHeader().getColumnModel().getColumn(1).setMinWidth(50);
        //Ordenar columnas en el JTable = TablaIndicadores
        TableRowSorter<TableModel> CampoEncabezado = new TableRowSorter<TableModel> (modelo);
        TablaIndicadores.setRowSorter(CampoEncabezado);
}
    void LimpiarTxts(){
            Txtid.setText("");
            TxtNombre.setText("");
            ComboNomIndi.removeAllItems();
            TxtFormula.setText("");
            TxtColor.setText("");
            TxtIndiPadre.setText("");
    }
    void Habilitar(){
        Txtid.setEnabled(true);
        TxtNombre.setEnabled(true);
        TxtFormula.setEnabled(true);
        TxtColor.setEnabled(true);
        TxtIndiPadre.setEnabled(true);
        ComboNomIndi.setEnabled(true);
    }
    void AgregarItemsIndicador(){
        int total = modelo.getRowCount()+1;
        ComboNomIndi.removeAllItems();
        String matris[][];
        Connection cn;
        String sql;
        PreparedStatement ps;
        ResultSet rs;
        ResultSet rs2;
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
                tabla[i][0]=rs.getBoolean(1);
                tabla[i][1]=rs.getString(2);
                tabla[i][2]=rs.getString(3);
		tabla[i][3]=rs.getString(4);
                tabla[i][4]=rs.getString(5);
                tabla[i][5]=rs.getInt(6);
                ComboNomIndi.addItem(""+rs.getBoolean(1)+",  "+rs.getObject(3));
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
            
        }

    }

/*
        try{
            sqli = "SELECT * FROM COM_Indicador ";
            psi = Indicador.cn.prepareStatement(sqli);
            rsi = psi.executeQuery();
            while(rsi.next()){

                        ComboNomIndi.addItem(rsi.getObject(3));
            }
         }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null,"Error en SQL "+e.getMessage());
        }
        
        JComboBox comboBox2 =new JComboBox();
        try {
            rsi = Indicador.ps.executeQuery("SELECT * FROM COM_Indicador ");
            while(rsi.next()){
                comboBox2.enable(true);
                comboBox2.addItem(rsi.getObject(3));
            }
        } catch (SQLException ex){
            Logger.getLogger(frmIndicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        TablaIndicadores.setCellEditor(new DefaultCellEditor(comboBox2)); //enfasis en esta linea!!!!
        DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox2);
        TablaIndicadores.getColumnModel().getColumn(4).setCellEditor(defaultCellEditor);
TablaIndicadores.getColumnModel().getColumn( 4 ).setCellEditor(new MyTableCellEditor(db,"IND_Color"));//Columna Edad
    }*/
    private Integer PosicionMarcado(DefaultTableModel lmodelo, int columna){
   try{
       for(int fila = 0; fila <= lmodelo.getRowCount() ; fila++){
           if(lmodelo.getValueAt(fila,columna).equals(true)){
             JOptionPane.showMessageDialog(null,"El Código del Indicador No fue encontrado:::   " +fila);
             return fila;
           }
       }
   }catch(Exception ex){
      JOptionPane.showMessageDialog(null,"El Código del Indicador No fue encontrado");
   }
   return -1;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToolIndicador = new javax.swing.JToolBar();
        NuevoIndicador = new javax.swing.JButton();
        ModificarIndicador = new javax.swing.JButton();
        AgregarIndicador = new javax.swing.JButton();
        EliminarIndicador = new javax.swing.JButton();
        BuscarIndicador = new javax.swing.JButton();
        ScrollIndicador = new javax.swing.JScrollPane();
        TablaIndicadores = new javax.swing.JTable();
        PanelLabel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Txtid = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtFormula = new javax.swing.JTextField();
        TxtColor = new javax.swing.JTextField();
        TxtIndiPadre = new javax.swing.JTextField();
        ComboNomIndi = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        TablaEditable = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Catalogo de Indicadores");

        ToolIndicador.setRollover(true);

        NuevoIndicador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Agregar.png"))); // NOI18N
        NuevoIndicador.setText("Nuevo");
        NuevoIndicador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoIndicadorActionPerformed(evt);
            }
        });
        ToolIndicador.add(NuevoIndicador);

        ModificarIndicador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Modificar.png"))); // NOI18N
        ModificarIndicador.setText("Modificar");
        ModificarIndicador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarIndicadorActionPerformed(evt);
            }
        });
        ToolIndicador.add(ModificarIndicador);

        AgregarIndicador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Guardar.png"))); // NOI18N
        AgregarIndicador.setText("Agregar");
        AgregarIndicador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarIndicadorActionPerformed(evt);
            }
        });
        ToolIndicador.add(AgregarIndicador);

        EliminarIndicador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/Eliminar.png"))); // NOI18N
        EliminarIndicador.setText("Eliminar");
        EliminarIndicador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarIndicadorActionPerformed(evt);
            }
        });
        ToolIndicador.add(EliminarIndicador);

        BuscarIndicador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comovamos/Iconos/search.png"))); // NOI18N
        BuscarIndicador.setText("Buscar");
        BuscarIndicador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarIndicadorActionPerformed(evt);
            }
        });
        ToolIndicador.add(BuscarIndicador);

        TablaIndicadores.setModel(modelo);
        TablaIndicadores.setIntercellSpacing(new java.awt.Dimension(3, 3));
        ScrollIndicador.setViewportView(TablaIndicadores);

        jLabel1.setText("Indicador Llave");

        jLabel2.setText("Nombre");

        jLabel3.setText("Indicador");

        jLabel4.setText("Formula");

        jLabel5.setText("Color");

        jLabel6.setText("Indicador Padre");

        javax.swing.GroupLayout PanelLabelLayout = new javax.swing.GroupLayout(PanelLabel);
        PanelLabel.setLayout(PanelLabelLayout);
        PanelLabelLayout.setHorizontalGroup(
            PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLabelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                        .addGroup(PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLabelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())))
        );
        PanelLabelLayout.setVerticalGroup(
            PanelLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLabelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        Txtid.setEnabled(false);
        Txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtidActionPerformed(evt);
            }
        });

        TxtNombre.setEnabled(false);
        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        TxtFormula.setEnabled(false);

        TxtColor.setEnabled(false);
        TxtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtColorKeyTyped(evt);
            }
        });

        TxtIndiPadre.setEnabled(false);
        TxtIndiPadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIndiPadreKeyTyped(evt);
            }
        });

        ComboNomIndi.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtColor, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(Txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(ComboNomIndi, 0, 199, Short.MAX_VALUE)
                    .addComponent(TxtFormula, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(TxtIndiPadre, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboNomIndi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtIndiPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TablaEditable.setText("Editable");
        TablaEditable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TablaEditableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TablaEditable, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(PanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
            .addComponent(ToolIndicador, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollIndicador, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)
                        .addGap(55, 55, 55)
                        .addComponent(TablaEditable)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtidActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_TxtidActionPerformed

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_TxtNombreActionPerformed

    private void TxtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtColorKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
}//GEN-LAST:event_TxtColorKeyTyped

    private void TxtIndiPadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIndiPadreKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
}//GEN-LAST:event_TxtIndiPadreKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = 0;
        String id_IND;
        try{
            while (fila <= modelo.getRowCount()+1){
                if(modelo.getValueAt(fila,0).equals(true)){
                    Txtid.setText(modelo.getValueAt(fila,1).toString());
                    TxtNombre.setText(modelo.getValueAt(fila,2).toString());
                    TxtFormula.setText(modelo.getValueAt(fila,3).toString());
                    TxtColor.setText(modelo.getValueAt(fila,4).toString());
                    TxtIndiPadre.setText(modelo.getValueAt(fila,5).toString());
                    codigo = modelo.getValueAt(fila,1).toString();
                        if(Indicador.BuscarIndicador(codigo)) {
                           int resp= JOptionPane.showConfirmDialog(this,"Esta Seguro de Eliminar Regitro ","Eliminar Dato",JOptionPane.YES_NO_OPTION );
                               if( resp == JOptionPane.YES_OPTION ){
                                    Indicador.EliminaIndicador(codigo);
                                    modelo.removeRow(fila);
                                    fila = -1;
                                    JOptionPane.showMessageDialog(this,"Registro Eliminado");
                                }
                           
                           } else {JOptionPane.showMessageDialog(null,"El Código del Indicador No fue encontrado");}                  
                    
                }
                fila++;
            }
        }
        catch(Exception ex){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaEditableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablaEditableActionPerformed
        // TODO add your handling code here:
        AgregarItemsIndicador();
    }//GEN-LAST:event_TablaEditableActionPerformed

    private void BuscarIndicadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarIndicadorActionPerformed
        Cargar();
        codigo=JOptionPane.showInputDialog("Ingrese el código del Indicador a Buscar:  ");
        Indicador.BuscarIndicador(codigo);
        if(Indicador.BuscarIndicador(codigo)) {
            Txtid.setText(String.valueOf(Indicador.getIND_id()));
            TxtNombre.setText(Indicador.getIND_Nombre());
            TxtFormula.setText(Indicador.getIND_Formula());
            TxtColor.setText(Indicador.getIND_Color());
            TxtIndiPadre.setText(String.valueOf(Indicador.getIND_Padre()));
        } else{
            JOptionPane.showMessageDialog(null,"El Código del Indicador No fue encontrado");
            LimpiarTxts();
            modelo.setDataVector(Indicador.Reportar(), nombreColumnas);
            TablaPer();
        }
        Indicador.Reportar();

        JCheckBox comboBox = new JCheckBox();
        JComboBox comboBox2 =new JComboBox();

        try {
            rsi = Indicador.ps.executeQuery("SELECT * FROM COM_Indicador ");
            while(rsi.next()){
                comboBox2.enable(true);
                comboBox2.addItem(rsi.getObject(3));
            }
        } catch (SQLException ex){
            Logger.getLogger(frmIndicador.class.getName()).log(Level.SEVERE, null, ex);
        }

        TablaIndicadores.setCellEditor(new DefaultCellEditor(comboBox2)); //enfasis en esta linea!!!!
        DefaultCellEditor defaultCellEditor=new DefaultCellEditor(comboBox2);
        TablaIndicadores.getColumnModel().getColumn(5).setCellEditor(defaultCellEditor);
        AgregarItemsIndicador();
}//GEN-LAST:event_BuscarIndicadorActionPerformed

    private void EliminarIndicadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarIndicadorActionPerformed
        codigo=JOptionPane.showInputDialog("Ingrese el código del Indicador a Buscar:  ");
        if(Indicador.BuscarIndicador(codigo)) {
            Txtid.setText(String.valueOf(Indicador.getIND_id()));
            TxtNombre.setText(Indicador.getIND_Nombre());
            TxtFormula.setText(Indicador.getIND_Formula());
            TxtColor.setText(Indicador.getIND_Color());
            TxtIndiPadre.setText(String.valueOf(Indicador.getIND_Padre()));
            int resp= JOptionPane.showConfirmDialog(this,"Esta Seguro de Eliminar Regitro ","Eliminar Dato",JOptionPane.YES_NO_OPTION );
            if( resp == JOptionPane.YES_OPTION ){
                Indicador.EliminaIndicador(codigo);
                JOptionPane.showMessageDialog(this,"Registro Eliminado");
                modelo.setDataVector(Indicador.Reportar(), nombreColumnas);
            }
            LimpiarTxts();
        } else JOptionPane.showMessageDialog(null,"El Código del Indicador No fue encontrado");
    }//GEN-LAST:event_EliminarIndicadorActionPerformed

    private void AgregarIndicadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarIndicadorActionPerformed

        if(!TxtFormula.getText().equals("") && !TxtNombre.getText().equals("") && !TxtColor.getText().equals("") && !TxtIndiPadre.getText().equals("")) {
            //IND_Nombre = TxtNombre.getText();
            IND_Nombre = (String) ComboNomIndi.getSelectedItem();
            JOptionPane.showMessageDialog(null,"Campo "+ IND_Nombre);
            IND_Formula = TxtFormula.getText();
            IND_Color = TxtColor.getText();
            IND_Padre = Integer.parseInt(TxtIndiPadre.getText());
            Indicador al = new Indicador(IND_flag,IND_id,IND_Nombre,IND_indicadorcol,IND_Formula,IND_Color,IND_Padre);
            if(reg) {
                Indicador.RegistrarIndicador();
                JOptionPane.showMessageDialog(null,"Indicador Registrado");
                modelo.setDataVector(Indicador.Reportar(), nombreColumnas);
            } else {
                Indicador.ModificarIndicador(codmod);
                JOptionPane.showMessageDialog(null,"Indicador Modificado");
                modelo.setDataVector(Indicador.Reportar(), nombreColumnas);
            }
        } else    JOptionPane.showMessageDialog(null,"Campos Vacios, Favor de Llenar Datos Correspondientes");
}//GEN-LAST:event_AgregarIndicadorActionPerformed

    private void ModificarIndicadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarIndicadorActionPerformed
        LimpiarTxts();
        AgregarItemsIndicador();
        Habilitar();
        codmod=JOptionPane.showInputDialog("Ingrese el código del Indicador a Buscar: ");
        if(Indicador.BuscarIndicador(codmod)) {
            Txtid.setText(String.valueOf(Indicador.getIND_id()));
            TxtNombre.setText(Indicador.getIND_Nombre());
            TxtFormula.setText(Indicador.getIND_Formula());
            TxtColor.setText(Indicador.getIND_Color());
            TxtIndiPadre.setText(String.valueOf(Indicador.getIND_Padre()));
            reg = false;
        } else{
            JOptionPane.showMessageDialog(null,"El Código del Indicador No fue encontrado");
            reg = true;
        }
}//GEN-LAST:event_ModificarIndicadorActionPerformed

    private void NuevoIndicadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoIndicadorActionPerformed
        LimpiarTxts();
        reg = true;
        rsi = null;
        ComboNomIndi.removeAllItems();
        try {
            rsi = Indicador.ps.executeQuery("SELECT * FROM COM_Indicador ");
            while(rsi.next()){
                ComboNomIndi.addItem(rsi.getObject(3));
            }
        } catch (SQLException ex){
            Logger.getLogger(frmIndicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Habilitar();
        AgregarItemsIndicador();
        Txtid.setEnabled(false);
        TxtNombre.requestFocus();
}//GEN-LAST:event_NuevoIndicadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarIndicador;
    private javax.swing.JButton BuscarIndicador;
    private javax.swing.JComboBox ComboNomIndi;
    private javax.swing.JButton EliminarIndicador;
    private javax.swing.JButton ModificarIndicador;
    private javax.swing.JButton NuevoIndicador;
    private javax.swing.JPanel PanelLabel;
    private javax.swing.JScrollPane ScrollIndicador;
    private javax.swing.JButton TablaEditable;
    private javax.swing.JTable TablaIndicadores;
    private javax.swing.JToolBar ToolIndicador;
    private javax.swing.JTextField TxtColor;
    private javax.swing.JTextField TxtFormula;
    private javax.swing.JTextField TxtIndiPadre;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField Txtid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}