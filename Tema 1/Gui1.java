package GUI;

import javax.swing.JFrame;

public class Gui1 extends JFrame {
    public Gui1(){
        super("Ventana Usando Herencia");//Titulo
        setSize(370,450);//Tamaño
        setLocationRelativeTo(null);/*La venrtana se posiona en el centro de la ántalla*/
                //Boton de cerrar
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// boton para cerrar
                setResizable(false);/*El tamñon no se puede modificar*/
                setVisible(true);
    }
}
