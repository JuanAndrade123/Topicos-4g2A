package GUI;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui3  extends JFrame{
    //constantes y compononetes
    private Container panel;
    private JButton miboton;
    public Gui3(){
    super("Ventana herenacia");//Titulo
    miboton= new JButton("Aceptar");
    panel=getContentPane();
    panel.add(miboton);
    setSize(200,200);//tamaño de ventana
    setLocationRelativeTo(null);//posicion centrada
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);//No se puede modificar el tamaño
        setVisible(true);
    }
}
