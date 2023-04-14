package IO;

import TDA.Asistentes;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Totales {

    ArrayList<Asistentes> asistentes = new ArrayList<>();
    
    // Metodos CRUD
    public void registrar (Asistentes nuevo) {
        asistentes.add(nuevo);
    }
    public Asistentes crear (String nombre, byte edad, String sexo, String estadoCivil) {
        return new Asistentes(nombre, edad, sexo, estadoCivil);
    }
    public void eliminar (Asistentes aux) {
        asistentes.remove(aux);
    }
    
    // Metodos Total
    public int totalAsistentes () {
        return asistentes.size();
    }
    public int totalMayorEdad () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total += (asistente.getEdad() >= 18) ? 1 : 0;
        return total;
    }
    public int totalMenorEdad () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEdad() < 18) ? 1 : 0;
        return total;
    }
    public int totalHombres () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getSexo().equalsIgnoreCase("masculino")) ? 1 : 0;
        return total;
    }
    public int totalMujeres () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getSexo().equalsIgnoreCase("femenino")) ? 1 : 0;
        return total;
    }
    public int totalSolteros () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("soltero")) ? 1 : 0;
        return total;
    }
    public int totalCasados () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("casado")) ? 1 : 0;
        return total;
    }
    public int totalViudos () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("viudo")) ? 1 : 0;
        return total;
    }
    public int totalDivorciados () {
        int total = 0;
        for (Asistentes asistente : asistentes)
            total +=(asistente.getEstadoCivil().equalsIgnoreCase("divorciado")) ? 1 : 0;
        return total;
    }
    public float porcentajeHombres () {
        return ((float)totalHombres() / asistentes.size()) * 100;
    }
    public float porcentajeMujeres () {
        return ((float)totalMujeres() / asistentes.size()) * 100;
    }
    
    public String stadistics () {
        String totales = "Asistentes en Total: " + totalAsistentes() + "\n\n"
                + "Personas Mayores Edad: " + totalMayorEdad() + "\n"
                + "Personas Menores Edad: " + totalMenorEdad() + "\n\n"
                + "Total de Hombres: " + totalHombres() + "\n"
                + "Total de Mujeres: " + totalMujeres() + "\n\n"
                + "Total de Solteros: " + totalSolteros() + "\n"
                + "Total de Casados: " + totalCasados() + "\n"
                + "Total de Viudos: " + totalViudos() + "\n"
                + "Total de Divorciados: " + totalDivorciados() + "\n\n"
                + String.format("Porcentaje Hombres: %.2f%% \n", porcentajeHombres())
                + String.format("Porcentaje Mujeres: %.2f%%", porcentajeMujeres());
        return totales;
    }
    
    // Metodos de Prueba
    public void datosBrutos (DefaultListModel model) {
        Asistentes a1 = new Asistentes("JuanPi", (byte)15, "masculino", "soltero");
        Asistentes a2 = new Asistentes("david", (byte)54, "masculino", "viudo");
        Asistentes a3 = new Asistentes("shaggy", (byte)13, "masculino", "soltero");
        Asistentes a4 = new Asistentes("ana", (byte)35, "femenino", "casado");
        Asistentes a5 = new Asistentes("diana", (byte)45, "femenino", "divorciado");
        asistentes.add(a1);
        model.add(0, a1);
        asistentes.add(a2);
        model.add(1, a2);
        asistentes.add(a3);
        model.add(2, a3);
        asistentes.add(a4);
        model.add(3, a4);
        asistentes.add(a5);
        model.add(4, a5);
    }
    public String viewAll () {
        String info = "";
        for (Asistentes aux : asistentes)
            info += aux.toString() + "\n";
        String totales = "Total: " + totalAsistentes() + "\n"
                + "Personas Mayores Edad: " + totalMayorEdad() + "\n"
                + "Personas Menores Edad: " + totalMenorEdad() + "\n"
                + "Total de Hombres: " + totalHombres() + "\n"
                + "Total de Mujeres: " + totalMujeres() + "\n"
                + "Total de Solteros: " + totalSolteros() + "\n"
                + "Total de Casados: " + totalCasados() + "\n"
                + "Total de Viudos: " + totalViudos() + "\n"
                + "Total de Divorciados: " + totalDivorciados() + "\n"
                + String.format("Porcentaje Hombres: %.2f%% \n", porcentajeHombres())
                + String.format("Porcentaje Mujeres: %.2f%%", porcentajeMujeres());
        return info + "\n\n\n" + totales;
    }
    
    
}
