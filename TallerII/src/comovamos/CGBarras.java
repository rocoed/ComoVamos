package comovamos;

import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
import java.io.*;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class CGBarras {
    //Nuestra clase de CGBarras tendrá los atributos de datos, nombre de la gráfica,
    //nombre eje x, nombre eje y las etiquetas de cada barra
    DefaultCategoryDataset datos= new DefaultCategoryDataset();//incluye etiqueta de cada barra y su valor
    String nombreg,nombrex,nombrey;
    JFreeChart grafico;
    private BufferedImage image;
    //constructor
    public CGBarras(String a, String b, String c, DefaultCategoryDataset d){
        datos=d;
        nombreg=a;
        nombrex=b;
        nombrey=c;    
    }
    
    //Métodos
    public BufferedImage creagrafico(){
        grafico = ChartFactory.createBarChart(nombreg,nombrex, nombrey, datos, PlotOrientation.VERTICAL, false,true, false);
        image = grafico.createBufferedImage(400,280);
        return image;
    }
    
    public void exportargrafico(String n,int x, int y, String tipo){
        if(tipo.equals("2")){
            try {              
                ChartUtilities.saveChartAsJPEG(new File(n+".jpg"), grafico, y,x);
            }catch (IOException e) {
                System.err.println("Error creando grafico.");
            }
            }else{
                if(tipo.equals("1")){
                    try {
                        OutputStream file = new FileOutputStream(new File(n+".pdf"));
                        Document document = new Document();                        
                        PdfWriter.getInstance(document, file);
                        document.open();
                        document.add(new Paragraph("Aquí el gráfico:\n"));
                        ChartUtilities.saveChartAsJPEG(new File(n+".jpg"), grafico, y,x);                       
                        Image imagen=Image.getInstance(n+".jpg");
                        document.add(imagen);
                        File borrar=new File(n+".jpg");
                        borrar.delete();
                        document.close();
                        file.close();
                        JOptionPane.showMessageDialog(null,"Se creó el pdf satisfactoriamente");
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    
                }else{
                    if(tipo.equals("3")){
                        try {    
                            ChartUtilities.saveChartAsPNG(new File(n+".png"), grafico, y,x);
                        }catch (IOException e) {
                        System.err.println("Error creando grafico.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No está el tipo de formato para guardado");
                        }
                    }
                }
    }
    
    
}
