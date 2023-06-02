package TDA;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Grafica {
    
    private static int calificacion;
    
    public static PieDataset datos (int total) {
        DefaultPieDataset estadisticas = new DefaultPieDataset();
        
        estadisticas.setValue("Correcto", total);
        estadisticas.setValue("Incorrecto", 10 - total);
        
        calificacion = total;
        
        return estadisticas;
    }
    
    public static void crearGrafica (PieDataset datos) {
        JFreeChart resultados;
        resultados = ChartFactory.createPieChart("CALIFICACION: " + calificacion*10 + "%", datos);
        
        crearPanel(resultados);
    }
    
    public static void crearPanel (JFreeChart pie) {
        ChartPanel resultados = new ChartPanel(pie);
        JFrame frame = new JFrame("RESULTADOS");
        frame.setLayout(new FlowLayout());
        frame.add(resultados);
        frame.pack();
        frame.setVisible(true);
    }
    
}
