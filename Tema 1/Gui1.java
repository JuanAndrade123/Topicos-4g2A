package GUI;

import javax.swing.JFrame;

// Constantes y Componentes (Objeto)

public class Gui1 extends JFrame {
    
    public Gui1(){
        super("Ventana usando Herencia"); // Establece el titulo de la ventana
        setSize(370,450); // Establece el Tamaño de la Ventana
        setLocationRelativeTo(null); // La ventana se posiciona en el centro de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // El boton cerrar permitira salir de la aplicacion
        setResizable(false); // Impide que la ventana se pueda dimensionar
        setVisible(true);
    }
    
}
