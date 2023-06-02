package TDA;

import Media.Pictures;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Questions {

    // Preguntas
    public final String [] preguntas = {"La clase Graphics permite dibujar:",
                                        "\u00bfEs el metodo que pinta el componente dentro de la clase Graphics?",
                                        "La clase Graphics no se instancia directamente, sino que se crea un componente y se pasa como un __________ al metodo Paint()",
                                        "\u00bfCual es el metodo que se usa para ingresar texto?",
                                        "\u00bfQue hace el metodo setFont?",
                                        "La clase AWT es indispensable para el uso de la clase Graphics",
                                        "\u00bfQue categorias de operaciones graficas existen en la clase Graphics?",
                                        "\u00bfQue metodo se utiliza para trazar el contorno de un poligono?",
                                        "\u00bfQue clase es necesaria para acceder a metodos de dibujo?",
                                        "\u00bfSe puede modificar el tamaño de las imagenes utilizando la clase Graphics?"};
    
    // Respuestas
    public final String [] respuestas = {"Todas las Anteriores",
                                         "paint()",
                                         "argumento",
                                         "drawString()",
                                         "<html><body align='center'>Establece la fuente usada<p>para imprimir cadenas de<p>caracteres</body></html>",
                                         "Verdadero",
                                         "Todas las Anteriores",
                                         "drawRect()",
                                         "Graphics2D",
                                         "Falso"};
    
    // Opciones Extra
    public final String [][] opciones = {{"Elipses", "Cuadros", "Lineas"},
                                         {"drawLine()", "drawRect()", "main()"},
                                         {"objeto", "atributo", "Ninguna las Anteriores"},
                                         {"drawLine()", "setLayout()", "drawRect()"},
                                         {"<html><body align='center'>Dibuja la cadena de texto <p> especificada en el rectangulo <p> que se indique</body></html>",
                                            "<html><body align='center'>Imprime una linea, desde <p> una coordenada [x, y] hasta <p> una segunda coordenada [x<sub>2</sub>, y<sub>2</sub>]</body></html>",
                                            "<html><body align='center'>Se usa para cambiar el color <p> de letra del texto usado <p> en la etiqueta</body></html>"}, 
                                         {"Falso", "", ""},
                                         {"Dibujo de Primitivas Graficas", "Dibujo de Texto", "<html><body align='center'>Presentacion de imagenes en <p> diferentes formatos</body></html>"},
                                         {"setStroke()", "drawLine()", "fillRect()"},
                                         {"JFrame", "Paint", "Ninguna de las Anteriores"},
                                         {"Verdadero", "", ""}};
    
    public String [][] mezcla = new String [10][4];
    
    public int vF1 =-1 , vF2 = -1;
    

    // Para mezclar al inicio
    public Random random = new Random();
        
    // Contestado
    public String [] contestado = new String [10];
    
    // Indice
    private int indice;
    
    // Metodos
    public Questions (JLabel imagen) {
        indice = 0;
        for (int i = 0; i < 10; i++)
            contestado[i] = "";
        imagenes = new Pictures(imagen);
        mezclarTodo();
    }
    
    
    public void mezclarTodo () {
        // For que Asigna Opciones
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 4; j++) {
                if (j < 3)
                    mezcla[i][j] = opciones[i][j];
                else
                    mezcla[i][j] = respuestas[i];
            }
        // For que Mezcla Opciones
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 4; j++) {
                int randJ = random.nextInt(4);
                String aux = mezcla[i][randJ];
                mezcla[i][randJ] = mezcla[i][j];
                mezcla[i][j] = aux;
            }
        // For que Mezcla Todo
        for (int i = 0; i < 10; i++) {
            int azar = random.nextInt(10);
            
            // Para Opciones
            String [] auxOpciones = mezcla[azar];
            mezcla[azar] = mezcla[i];
            mezcla[i] = auxOpciones;
            
            // Para Imagen
            imagenes.mezclar(i, azar);
            
            // Para Preguntas
            String auxPreguntas = preguntas[azar];
            preguntas[azar] = preguntas[i];
            preguntas[i] = auxPreguntas;
            
            // Para Respuestas al Comparar
            String auxRespuestas = respuestas[azar];
            respuestas[azar] = respuestas[i];
            respuestas[i] = auxRespuestas;
            
        }
        // Busca cuales son de Verdadero/Falso
        for (int i = 0; i < 10; i++) {
            if (preguntas[i].contains("La clase AWT es indispensable para el uso de la clase Graphics")
                    || preguntas[i].contains("\u00bfSe puede modificar el tamaño de las imagenes utilizando la clase Graphics?")) {
                if (vF1 == -1) vF1 = i;
                else vF2 = i;
            }
        }
        
    }
    
    public String [] establecer () {
        return mezcla[indice];
    }
    
    public void previous () {
        indice--;
    }
    public void next () {
        indice++;
    }
    public void select (int i) {
        indice = i;
    }
    
    public String pregunta() {
        return preguntas[indice];
    }
    
    public int indice(){
        return indice;
    }
    public int evaluar(){
        int correct = 0;
        for(int i = 0; i < 10; i++)
            if (contestado[i].contains(respuestas[i]))
                correct++;
        return correct;
    }
    
    private Pictures imagenes;
    
    public Icon imagen () {
        return imagenes.getIcon(indice());
    }
    
}
