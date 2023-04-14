package GUI;

import IO.Totales;
import java.awt.GridLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Graficos {
    
    public static CategoryDataset edad (Totales estadisticas) {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        
        datos.addValue(estadisticas.totalMayorEdad(), "Mayor de Edad", "Mayores");
        datos.addValue(estadisticas.totalMenorEdad(), "Menor de Edad", "Menores");
        
        return datos;
    }
    
    public static CategoryDataset sexo (Totales estadisticas) {
        DefaultCategoryDataset sexo = new DefaultCategoryDataset();
        
        sexo.addValue(estadisticas.totalHombres(), "Hombres", "Hombres");
        sexo.addValue(estadisticas.totalMujeres(), "Mujeres", "Mujeres");
        
        return sexo;
    }
    
    public static CategoryDataset civil (Totales estadisticas) {
        DefaultCategoryDataset estados = new DefaultCategoryDataset();
        
        estados.addValue(estadisticas.totalSolteros(), "Soltero", "Solteros");
        estados.addValue(estadisticas.totalCasados(), "Casado", "Casados");
        estados.addValue(estadisticas.totalViudos(), "Viudo", "Viudos");
        estados.addValue(estadisticas.totalDivorciados(), "Divorciado", "Divorciados");
        
        return estados;
    }
    
    public static PieDataset porcentaje (Totales estadisticas) {
        DefaultPieDataset edad = new DefaultPieDataset();
        
        edad.setValue("Hombres", estadisticas.porcentajeHombres());
        edad.setValue("Mujeres", estadisticas.porcentajeMujeres());
        
        return edad;
    }
    
    public static void crearGraficas (CategoryDataset datosEdad, CategoryDataset datosSexo, CategoryDataset datosCivil, PieDataset porcentaje, Totales total) {
        JFreeChart graficaEdad, graficaSexo, graficaCivil, graficaPorcentajes;
        graficaEdad = ChartFactory.createBarChart("Edades", "", "Total", datosEdad);
        graficaSexo = ChartFactory.createBarChart("Sexos", "", "Total", datosSexo);
        graficaCivil = ChartFactory.createBarChart("Estado Civil", "", "Total", datosCivil);
        graficaPorcentajes = ChartFactory.createPieChart("Porcentaje de Asistencia", porcentaje);
        
        
        crearPanel(graficaEdad, graficaSexo, graficaCivil, graficaPorcentajes, total.totalAsistentes());
    }
    
    public static void crearPanel (JFreeChart edad, JFreeChart sexo, JFreeChart civil, JFreeChart porcentajes, int total) {
        ChartPanel edades = new ChartPanel(edad);
        ChartPanel sexos = new ChartPanel(sexo);
        ChartPanel estados = new ChartPanel(civil);
        ChartPanel porcentaje = new ChartPanel(porcentajes);
        
        JFrame frame = new JFrame("Total de Asistentes: " + total);
        frame.setLayout(new GridLayout(2, 2, 15, 15));
        frame.add(edades);
        frame.add(sexos);
        frame.add(estados);
        frame.add(porcentaje);
        frame.pack();
        frame.setVisible(true);
    }
    
}
